package com.example.recipebazzar.Domain.UseCases

import android.util.Log
import com.example.recipebazzar.Data.RemoteData.toMeal_Info
import com.example.recipebazzar.Domain.DomainRepository.StoreRepository
import com.example.recipebazzar.Domain.Models.Meal_Info
import com.example.recipebazzar.Domain.Models.OnlineStore
import com.example.recipebazzar.Domain.NetworkUtils.NetworkEvents
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetOnlineStores @Inject constructor(private  val repository: StoreRepository){

 operator fun invoke(store_category: String) = repository.getOnlineStores(store_category)





}