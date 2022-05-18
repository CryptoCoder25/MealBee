package com.example.recipebazzar.Presentation.Screens.MealInfo_Page

import com.example.recipebazzar.Domain.Models.Meal
import com.example.recipebazzar.Domain.Models.Meal_Info

data class MealInfoStates(val isLoading: Boolean = false,
                          val mealinfo: List<Meal_Info> = emptyList(),
                          val error: String = "")


