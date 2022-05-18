package com.example.recipebazzar.Presentation.Screens.Main_Page.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppBottomItem(
    val id:String,
    val title:String,
    val icon: ImageVector,
){

    object Home: AppBottomItem("home","Home", Icons.Outlined.Home)
    object Search: AppBottomItem("seacrh","Checklist",Icons.Outlined.List)
    object Profile: AppBottomItem("profile","Scheduled Meal",Icons.Outlined.DateRange)
    object Settings: AppBottomItem("settings","Exit",Icons.Outlined.ExitToApp)

    object Items{
        val list= listOf(
            Home, Search, Profile, Settings
        )
    }

}
