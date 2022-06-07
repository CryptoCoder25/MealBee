package com.example.recipebazzar.Domain.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recipebazzar.Presentation.ui.theme.*


@Entity
data class CheckListNote(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
){

    companion object {
        val  checkListNoteColors = listOf(ClayBlue, ClayMint, ClayViolet, ClayYellow)
    }
}


