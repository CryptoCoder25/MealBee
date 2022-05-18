package com.example.recipebazzar.Presentation.Screens.Main_Page

sealed class MainPageEvent {

   data class onClickCategory(val category: String): MainPageEvent()

    object onClickNoteItem: MainPageEvent()

    object onClickScheduledMealItem: MainPageEvent()


}
