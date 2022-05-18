package com.example.recipebazzar.Presentation.Screens.MealsList_Page

sealed class MealsListEvents {

      data class  onClickMealItem(val mealId: String): MealsListEvents()

}
