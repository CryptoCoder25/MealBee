package com.example.recipebazzar.Presentation.Screens.NoteScreen_Page

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.recipebazzar.Presentation.PublicEvents.PublicUiEvents


@Composable
fun NoteScreenPage(
    onNavigate: (PublicUiEvents.Navigate) -> Unit,
){

    Text(
        text = "MEAL CATEGORIES",
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp

    )
}