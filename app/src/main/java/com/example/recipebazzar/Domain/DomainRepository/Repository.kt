package com.example.recipebazzar.Domain.DomainRepository

import com.example.recipebazzar.Data.RemoteData.Meals_Dto_Response
import com.example.recipebazzar.Data.RemoteData.Meals_Info_Dto_Response

interface Repository {

    suspend fun getMeals(category: String): Meals_Dto_Response

    suspend fun getMealInfo(mealId: String): Meals_Info_Dto_Response
}