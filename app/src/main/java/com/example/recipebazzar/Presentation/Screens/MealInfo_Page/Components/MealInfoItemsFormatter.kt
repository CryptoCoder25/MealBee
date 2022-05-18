package com.example.recipebazzar.Presentation.Screens.MealInfo_Page.Components

import com.example.recipebazzar.Domain.Models.Meal_Info

object MealInfoItemsFormatter {


    fun getIngredients(mealinfo : Meal_Info): List<String?>
    {

     return listOf<String?>(
           mealinfo.strIngredient1 ?: "0",
           mealinfo.strIngredient2 ?: "0",
           mealinfo.strIngredient3 ?: "0",
           mealinfo.strIngredient4 ?: "0",
           mealinfo.strIngredient5 ?: "0",
           mealinfo.strIngredient6 ?: "0",
           mealinfo.strIngredient7 ?: "0",
           mealinfo.strIngredient8 ?: "0",
           mealinfo.strIngredient9 ?: "0",
           mealinfo.strIngredient10 ?: "0",
           mealinfo.strIngredient11 ?: "0",
           mealinfo.strIngredient12 ?: "0",
           mealinfo.strIngredient13 ?: "0",
           mealinfo.strIngredient14 ?: "0",
           mealinfo.strIngredient15 ?: "0",
           mealinfo.strIngredient16 ?: "0",
           mealinfo.strIngredient17 ?: "0",
           mealinfo.strIngredient18 ?: "0",
           mealinfo.strIngredient19 ?: "0",
           mealinfo.strIngredient20 ?: "0")
    }

    fun getMeasurements(mealinfo : Meal_Info): List<String?>
    {

        return listOf<String?>(
            mealinfo.strMeasure1,
            mealinfo.strMeasure2,
            mealinfo.strMeasure3,
            mealinfo.strMeasure4,
            mealinfo.strMeasure5,
            mealinfo.strMeasure6,
            mealinfo.strMeasure7,
            mealinfo.strMeasure8,
            mealinfo.strMeasure9,
            mealinfo.strMeasure10,
            mealinfo.strMeasure11,
            mealinfo.strMeasure12,
            mealinfo.strMeasure13,
            mealinfo.strMeasure14,
            mealinfo.strMeasure15,
            mealinfo.strMeasure16,
            mealinfo.strMeasure17,
            mealinfo.strMeasure18,
            mealinfo.strMeasure19,
            mealinfo.strMeasure20)
    }
}