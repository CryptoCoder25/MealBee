package com.example.recipebazzar.Presentation.Screens.ScheduledMeal_Page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipebazzar.Presentation.PublicPresentationEvents.PublicUiEvents


@Composable
fun ScheduleMealPage(
    onNavigate: (PublicUiEvents.Navigate) -> Unit,
){

Scaffold(
    modifier = Modifier.fillMaxSize().padding(top = 15.dp),
    scaffoldState = rememberScaffoldState()
)
{
    Text(
        text = "Scheduled Meals",
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp

    )
}
}