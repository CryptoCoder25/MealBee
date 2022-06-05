package com.example.recipebazzar.Presentation.Screens.OnlineStores_Page

import com.example.recipebazzar.Domain.Models.Meal
import com.example.recipebazzar.Domain.Models.OnlineStore

data class OnlineStoreStates(
val isLoading: Boolean = false,
val stores: List<OnlineStore> = emptyList(),
val error: String = ""

)
