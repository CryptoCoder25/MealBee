package com.example.recipebazzar.Presentation.Screens.Main_Page

sealed class MainPageEvent {

   data class onClickCategory(val category: String): MainPageEvent()

    data class onClickAppBarItem(val itemId: String): MainPageEvent()

    data class onClickStore(val store_category: String): MainPageEvent()



}
