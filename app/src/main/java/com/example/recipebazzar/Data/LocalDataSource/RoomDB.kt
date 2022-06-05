package com.example.recipebazzar.Data.LocalDataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recipebazzar.Domain.Models.CheckListNote


@Database(
    entities = [CheckListNote::class],
    version = 1
)
abstract class RoomDB: RoomDatabase() {

    abstract val noteDao: CheckListNoteDao

    companion object {
        const val DATABASE_NAME = "CheckListNote_DB"
    }
}