package com.example.recipebazzar.Domain.DomainRepository

import com.example.recipebazzar.Domain.Models.CheckListNote
import com.example.recipebazzar.Domain.Models.OnlineStore
import com.example.recipebazzar.Domain.NetworkUtils.NetworkEvents
import kotlinx.coroutines.flow.Flow

interface StoreRepository {

    fun getOnlineStores(store_category: String): Flow<NetworkEvents<List<OnlineStore>>>


}