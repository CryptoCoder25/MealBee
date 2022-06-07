package com.example.recipebazzar.Domain.UseCases

import com.example.recipebazzar.Domain.DomainRepository.ChecklistRepository
import com.example.recipebazzar.Domain.Models.CheckListNote
import com.example.recipebazzar.Domain.Utils.CheckListNoteOrderBy
import com.example.recipebazzar.Domain.Utils.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CheckListNote_Operation @Inject constructor (private val repository: ChecklistRepository) {


   fun getNotes(noteOrder: CheckListNoteOrderBy = CheckListNoteOrderBy.Date(OrderType.Descending)):
           Flow<List<CheckListNote>> {

        return    repository.getNotes().map {   noteList ->
            when(noteOrder.orderType){

                is OrderType.Ascending ->{

                    when(noteOrder){
                        is CheckListNoteOrderBy.Title -> noteList.sortedBy { it.title.lowercase() }
                        is CheckListNoteOrderBy.Date -> noteList.sortedBy { it.timestamp }
                        is CheckListNoteOrderBy.Color -> noteList.sortedBy { it.color }

                    }

                }

                is OrderType.Descending ->{

                    when(noteOrder){
                        is CheckListNoteOrderBy.Title -> noteList.sortedByDescending { it.title.lowercase() }
                        is CheckListNoteOrderBy.Date -> noteList.sortedByDescending { it.timestamp }
                        is CheckListNoteOrderBy.Color -> noteList.sortedByDescending { it.color }

                    }
                }


            }


        }

    }


    suspend  fun deleteNote(note: CheckListNote){
         repository.deleteNote(note)
    }


    suspend fun insertNote(note: CheckListNote){
        repository.insertNote(note)

    }

    suspend  fun getNote(id: Int): CheckListNote? {
        return repository.getNoteById(id)
    }
}