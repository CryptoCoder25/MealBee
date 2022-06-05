package com.example.recipebazzar.Domain.NetworkUtils

import com.example.recipebazzar.Data.RemoteData.Meals_Dto
import com.example.recipebazzar.Data.RemoteData.Meals_Dto_Response
import com.example.recipebazzar.Data.RemoteData.Meals_Info_Dto_Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndpoints {

    @GET("filter.php")
    suspend fun getListByCategory(@Query("c") category: String): Meals_Dto_Response

    @GET("lookup.php")
    suspend fun getMealInfo(@Query("i") mealId: String): Meals_Info_Dto_Response

}