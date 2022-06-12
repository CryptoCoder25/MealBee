package com.example.recipebazzar.Presentation.Screens.Main_Page.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.UiConstant

sealed class AppBottomItem(
    val id:String,
    val title:String,
    val icon: ImageVector,
){

    object Home: AppBottomItem(UiConstant.MainPageAppBarItemId.home,"Home", Icons.Outlined.Home)
    object CheckList: AppBottomItem(UiConstant.MainPageAppBarItemId.checklist,"Checklist",Icons.Outlined.List)
    object BMICalculator: AppBottomItem(UiConstant.MainPageAppBarItemId.bmicaculator,"BMI Calculator",Icons.Outlined.Person)
    object Exit: AppBottomItem(UiConstant.MainPageAppBarItemId.exit,"Exit",Icons.Outlined.ExitToApp)

    object Items{
        val list= listOf(
            Home, CheckList,BMICalculator, Exit
        )
    }

}
