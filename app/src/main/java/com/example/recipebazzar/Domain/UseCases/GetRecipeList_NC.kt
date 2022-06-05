package com.example.recipebazzar.Domain.UseCases.GetRecipeUseCases

import android.util.Log
import com.example.recipebazzar.Data.RemoteData.toMeal
import com.example.recipebazzar.Domain.Models.Meal
import com.example.recipebazzar.Domain.DomainRepository.Repository
import com.example.recipebazzar.Domain.NetworkUtils.NetworkEvents
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetMealList_NC @Inject constructor(
    private val repository: Repository
){

    operator fun invoke(category: String): Flow<NetworkEvents<List<Meal>>> = flow {

        try {
            emit(NetworkEvents.Loading<List<Meal>>())
             val meals = repository.getMeals(category).data.map { it.toMeal()}
            Log.d("Data", repository.getMeals(category).data.toString())
            emit(NetworkEvents.Success<List<Meal>>(meals))
        } catch(e: HttpException) {
            emit(NetworkEvents.Error<List<Meal>>(e.localizedMessage ?: "An unexpected error occured"))
            Log.d("HttpException",e.localizedMessage)
        } catch(e: IOException) {
            emit(NetworkEvents.Error<List<Meal>>("Couldn't reach server. Check your internet connection."))
            Log.d("IOException",e.localizedMessage)
        }

    }
}