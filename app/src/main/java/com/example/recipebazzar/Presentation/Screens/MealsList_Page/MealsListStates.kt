package com.example.recipebazzar.Presentation.Screens.MealsList_Page

import com.example.recipebazzar.Domain.Models.Meal

data class MealsListStates(
    val isLoading: Boolean = false,
    val meals: List<Meal> = emptyList(),
    val error: String = ""
)


