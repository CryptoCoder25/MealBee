package com.example.recipebazzar.Presentation.Screens.CheckListNote_Page

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipebazzar.Domain.Models.CheckListNote
import com.example.recipebazzar.Domain.UseCases.CheckListNote_Operation
import com.example.recipebazzar.Domain.Utils.CheckListNoteOrderBy
import com.example.recipebazzar.Domain.Utils.OrderType
import com.example.recipebazzar.Presentation.PublicPresentationEvents.PublicUiEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class CheckListPageViewModel  @Inject constructor(
    private val checkListOperation: CheckListNote_Operation
): ViewModel()
{

    private val _state = mutableStateOf(CheckListNoteStates())
    val state: State<CheckListNoteStates> = _state

    private val _uiEvent =  Channel<PublicUiEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var recentlyDeletedNote: CheckListNote? = null

    private var getNotesJob: Job? = null

    init {
        getNotes(CheckListNoteOrderBy.Date(OrderType.Descending))
    }

    fun OnEvent(event: CheckListNoteEvent){

        when(event){

            is CheckListNoteEvent.onClikcOrderBy ->
            {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNotes(event.noteOrder)
            }

            is CheckListNoteEvent.onClickDeleteNote ->{
                viewModelScope.launch {
                    try {
                        checkListOperation.deleteNote(event.note)
                        recentlyDeletedNote = event.note
                        sendUiEvent(PublicUiEvents.ShowToastMessage("Successfully Deleted"))
                    } catch(e: HttpException) {
                        Log.d(" DELETE OPERATION","(HttpException) " +e.localizedMessage)
                        sendUiEvent(PublicUiEvents.ShowToastMessage("Unable to delete record, pls try again later..."))
                    } catch(e: IOException) {
                        sendUiEvent(PublicUiEvents.ShowToastMessage("Unable to delete record, pls try again later..."))
                        Log.d("DELETE OPERATION","(IOException) " +e.localizedMessage)
                    }
                }

            }
            is CheckListNoteEvent.RestoreNote ->{

                viewModelScope.launch {
                    try {
                       checkListOperation.insertNote(recentlyDeletedNote ?: return@launch)
                        recentlyDeletedNote = null
                        sendUiEvent(PublicUiEvents.ShowToastMessage("Restore Success"))
                    } catch(e: HttpException) {
                        Log.d(" UPDATE OPERATION","(HttpException) " +e.localizedMessage)
                        sendUiEvent(PublicUiEvents.ShowToastMessage("Unable to restore record, pls try again later..."))
                    } catch(e: IOException) {
                        sendUiEvent(PublicUiEvents.ShowToastMessage("Unable to restore record, pls try again later..."))
                        Log.d("UPDATE OPERATION","(IOException) " +e.localizedMessage)
                    }
                }

            }

            is CheckListNoteEvent.ToggleOrderSection -> {
            _state.value = state.value.copy(
                isOrderSectionVisible = !state.value.isOrderSectionVisible
            )
        }




        }


    }

    private fun getNotes(noteOrder: CheckListNoteOrderBy) {
        getNotesJob?.cancel()
        getNotesJob = checkListOperation.getNotes(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }



    private fun sendUiEvent(event: PublicUiEvents) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}