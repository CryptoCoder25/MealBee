package com.example.recipebazzar.Domain.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recipebazzar.Presentation.ui.theme.BG3
import com.example.recipebazzar.Presentation.ui.theme.Purple700
import com.example.recipebazzar.Presentation.ui.theme.TCOLOR223
import com.example.recipebazzar.Presentation.ui.theme.Teal200


@Entity
data class CheckListNote(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
){

    companion object {
        val  checkListNoteColors = listOf(Teal200,Purple700, BG3,TCOLOR223)
    }
}


