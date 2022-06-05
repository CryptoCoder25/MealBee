package com.example.recipebazzar.Data.DataRepository

import com.example.recipebazzar.Data.RemoteData.Meals_Dto_Response
import com.example.recipebazzar.Data.RemoteData.Meals_Info_Dto_Response
import com.example.recipebazzar.Domain.DomainRepository.Repository
import com.example.recipebazzar.Domain.NetworkUtils.ApiEndpoints
import javax.inject.Inject




class RepositoryImpl @Inject constructor(private val api: ApiEndpoints) : Repository {

    override suspend fun getMeals(category: String): Meals_Dto_Response {
       return api.getListByCategory(category)
    }

    override suspend fun getMealInfo(mealId: String): Meals_Info_Dto_Response {
        return api.getMealInfo(mealId)
    }


}