package com.example.recipebazzar.Presentation.Screens.Main_Page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipebazzar.Presentation.PublicEvents.PublicUiEvents
import com.example.recipebazzar.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainPageViewModel @Inject constructor(): ViewModel() {

    private val _uiEvent =  Channel<PublicUiEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun MainPageEventVM(event: MainPageEvent){

         when(event){

             is MainPageEvent.onClickCategory ->{
                 sendUiEvent(PublicUiEvents.Navigate(Routes.MealListScreen + "?category=${event.category}"))
             }

             is MainPageEvent.onClickNoteItem ->{
                 sendUiEvent(PublicUiEvents.Navigate(Routes.NoteScreen))
             }

             is MainPageEvent.onClickScheduledMealItem->{
                 sendUiEvent(PublicUiEvents.Navigate(Routes.ScheduledMealScreen))
             }


         }

    }

    private fun sendUiEvent(event: PublicUiEvents) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}