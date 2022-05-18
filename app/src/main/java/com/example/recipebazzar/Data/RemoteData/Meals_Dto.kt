package com.example.recipebazzar.Data.RemoteData

import com.example.recipebazzar.Domain.Models.Meal
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Meals_Dto_Response(
@Json(name="meals")
val data: List<Meals_Dto>
)
data class Meals_Dto
    (
    @Json(name="idMeal")
    val MealId: String,
    @Json(name="strMeal")
    val MealName: String,
    @Json(name="strMealThumb")
    val MealImage: String
    )


fun Meals_Dto.toMeal(): Meal {
    return Meal (
         MealId = MealId,
         MealName = MealName,
         MealImage = MealImage
    )
}
