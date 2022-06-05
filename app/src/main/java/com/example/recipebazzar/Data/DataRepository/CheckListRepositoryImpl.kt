package com.example.recipebazzar.Data.DataRepository

import com.example.recipebazzar.Data.LocalDataSource.CheckListNoteDao
import com.example.recipebazzar.Domain.DomainRepository.ChecklistRepository
import com.example.recipebazzar.Domain.Models.CheckListNote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CheckListRepositoryImpl @Inject constructor(private val dao: CheckListNoteDao): ChecklistRepository {

    override fun getNotes(): Flow<List<CheckListNote>> {
       return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): CheckListNote? {
      return  dao.getNoteById(id)
    }

    override suspend fun insertNote(note: CheckListNote) {

        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: CheckListNote) {
      dao.deleteNote(note)
    }


}