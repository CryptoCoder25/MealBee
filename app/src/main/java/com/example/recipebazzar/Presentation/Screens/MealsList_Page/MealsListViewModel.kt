package com.example.recipebazzar.Presentation.Screens.MealsList_Page

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipebazzar.Domain.NetworkCalls.GetMealList_NC

import com.example.recipebazzar.NetworkUtils.NetworkEvents
import com.example.recipebazzar.Presentation.PublicEvents.PublicUiEvents
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageEvent
import com.example.recipebazzar.Routes
import com.example.recipebazzar.Utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class MealsListViewModel @Inject constructor(
    private val getMealList: GetMealList_NC,
    savedStateHandle: SavedStateHandle
): ViewModel() {


    private val _state = mutableStateOf(MealsListStates())
    val state: State<MealsListStates> = _state



    private val _uiEvent =  Channel<PublicUiEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init{
        savedStateHandle.get<String>(Constants.MealsCategory)?.let {
                category -> loadMeals(category)

        }

    }


   private fun loadMeals(category: String){

       getMealList(category).onEach { result ->

            when (result)
            {
                is NetworkEvents.Success ->{
                   _state.value = MealsListStates(meals =  result.data ?: emptyList() )

                }

                is NetworkEvents.Loading ->{

                    _state.value = MealsListStates(isLoading = true)
                }

                is NetworkEvents.Error ->{

                    _state.value = MealsListStates(error =  result.message ?: "An unexpected error occured")
                }

            }


       }.launchIn(viewModelScope)

   }


     fun OnEvent(event: MealsListEvents)
       {
                  when(event)
                  {
                      is MealsListEvents.onClickMealItem ->{
                           sendUiEvent(PublicUiEvents.Navigate(
                               Routes.MealInfoScreen + "?MEAL_ID=${event.mealId}"))

                      }

                  }


       }



    private fun sendUiEvent(event: PublicUiEvents) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }




}