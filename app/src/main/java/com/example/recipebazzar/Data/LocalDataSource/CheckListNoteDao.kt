package com.example.recipebazzar.Data.LocalDataSource

import androidx.room.*
import com.example.recipebazzar.Domain.Models.CheckListNote
import kotlinx.coroutines.flow.Flow


@Dao
interface CheckListNoteDao {


    @Query("SELECT * FROM CheckListNote")
    fun getNotes(): Flow<List<CheckListNote>>

    @Query("SELECT * FROM CheckListNote where id = :id")
    suspend fun getNoteById(id: Int): CheckListNote?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: CheckListNote)

    @Delete
    suspend fun deleteNote(note: CheckListNote)
}