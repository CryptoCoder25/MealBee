package com.example.recipebazzar.Domain.DomainRepository

import com.example.recipebazzar.Domain.Models.CheckListNote
import com.example.recipebazzar.Domain.NetworkUtils.NetworkEvents
import kotlinx.coroutines.flow.Flow

interface ChecklistRepository {

    fun getNotes(): Flow<List<CheckListNote>>

    suspend fun getNoteById(id: Int): CheckListNote?

    suspend fun insertNote(note: CheckListNote)

    suspend fun deleteNote(note: CheckListNote)
}