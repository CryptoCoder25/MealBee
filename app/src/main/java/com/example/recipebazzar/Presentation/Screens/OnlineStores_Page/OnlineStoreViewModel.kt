package com.example.recipebazzar.Presentation.Screens.OnlineStores_Page

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipebazzar.Domain.NetworkUtils.NetworkEvents
import com.example.recipebazzar.Domain.UseCases.GetOnlineStores
import com.example.recipebazzar.Utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class OnlineStoreViewModel @Inject constructor(
       private  val getOnlineStores: GetOnlineStores,
       savedStateHandle: SavedStateHandle
        ): ViewModel() {

    private val _state = mutableStateOf(OnlineStoreStates())
    val state: State<OnlineStoreStates> = _state





    init {
        savedStateHandle.get<String>(Constants.StoreCategory)?.let {
                category -> loadOnlineStores(category)
            Log.d("STORE_CATEGORY",category)
        }
    }

    private fun loadOnlineStores(storeCategory: String){

        getOnlineStores(storeCategory).onEach { result ->

                when(result){

                    is NetworkEvents.Success ->{

                            _state.value = OnlineStoreStates(stores =  result.data ?: emptyList() )

                        Log.d("FIRESTORE-SUCCESS",result.data.toString())
                    }

                    is NetworkEvents.Loading ->{
                        Log.d("FIRESTORE-LOADING",result.toString())
                        _state.value = OnlineStoreStates(isLoading = true)
                    }

                    is NetworkEvents.Error ->{
                        Log.d("FIRESTORE-ERROR",result.toString())
                        _state.value = OnlineStoreStates(error =  result.message ?: "An unexpected error occured")
                    }

                }

        }.launchIn(viewModelScope)
    }




}