package com.example.recipebazzar.Domain.Repositories

import com.example.recipebazzar.Data.RemoteData.Meals_Dto
import com.example.recipebazzar.Data.RemoteData.Meals_Dto_Response
import com.example.recipebazzar.Data.RemoteData.Meals_Info_Dto_Response
import com.example.recipebazzar.NetworkUtils.ApiEndpoints
import javax.inject.Inject




class RepositoryImplementation @Inject constructor(private val api: ApiEndpoints) : Repository{

    override suspend fun getMeals(category: String): Meals_Dto_Response {
       return api.getListByCategory(category)
    }

    override suspend fun getMealInfo(mealId: String): Meals_Info_Dto_Response {
        return api.getMealInfo(mealId)
    }


}