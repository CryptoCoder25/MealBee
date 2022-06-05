package com.example.recipebazzar.Domain.UseCases

import android.util.Log
import com.example.recipebazzar.Data.RemoteData.toMeal_Info
import com.example.recipebazzar.Domain.Models.Meal_Info
import com.example.recipebazzar.Domain.DomainRepository.Repository
import com.example.recipebazzar.Domain.NetworkUtils.NetworkEvents
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMealInfo_NC @Inject constructor
    (private val repository: Repository)
{

    operator fun invoke(mealId: String): Flow<NetworkEvents<List<Meal_Info>>> = flow {

        try {
            emit(NetworkEvents.Loading<List<Meal_Info>>())
            val meal_info = repository.getMealInfo(mealId).dataList.map { it.toMeal_Info() }
            Log.d("MealInfoResponse", repository.getMealInfo(mealId).dataList.toString()+mealId)
            emit(NetworkEvents.Success<List<Meal_Info>>(meal_info))
        } catch(e: HttpException) {
            emit(NetworkEvents.Error<List<Meal_Info>>("MealInfo network call, unexpected error occured "))
            Log.d("HttpException",e.localizedMessage)
        } catch(e: IOException) {
            emit(NetworkEvents.Error<List<Meal_Info>>("MealInfo network call, couldn't reach server. Check your internet connection."))
            Log.d("IOException",e.localizedMessage)
        }

    }
}