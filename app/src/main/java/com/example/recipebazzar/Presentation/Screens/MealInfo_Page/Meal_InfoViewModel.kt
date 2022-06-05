package com.example.recipebazzar.Presentation.Screens.MealInfo_Page

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipebazzar.Domain.UseCases.GetMealInfo_NC
import com.example.recipebazzar.Domain.NetworkUtils.NetworkEvents
import com.example.recipebazzar.Presentation.PublicPresentationEvents.PublicUiEvents
import com.example.recipebazzar.Utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class Meal_InfoViewModel @Inject constructor(
    private val getMealInfo: GetMealInfo_NC,
    savedStateHandle: SavedStateHandle
): ViewModel() {


    private val _state = mutableStateOf(MealInfoStates())
    val state: State<MealInfoStates> = _state

    private val _uiEvent =  Channel<PublicUiEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        savedStateHandle.get<String>(Constants.MealsId)?.let {
            getMealInfoVM(it)
        }

    }


    fun getMealInfoVM(mealId: String){

        getMealInfo(mealId).onEach { result ->

            when (result)
            {
                is NetworkEvents.Success ->{
                    _state.value = MealInfoStates(mealinfo = result.data ?: emptyList())
                    Log.d("MealInfoData", result.data.toString())
                }
                is NetworkEvents.Loading ->{
                    Log.d("LOADING", result.data.toString())
                    _state.value = MealInfoStates(isLoading = true)
                }

                is NetworkEvents.Error ->{
                    Log.d("ERROR", result.data.toString())
                    _state.value = MealInfoStates(error =  result.message ?: "An unexpected error occured")
                }

            }


        }.launchIn(viewModelScope)
    }


    private fun sendUiEvent(event: PublicUiEvents) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }


}