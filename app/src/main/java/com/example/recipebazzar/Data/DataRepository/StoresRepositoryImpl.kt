package com.example.recipebazzar.Data.DataRepository

import com.example.recipebazzar.Domain.DomainRepository.StoreRepository
import com.example.recipebazzar.Domain.Models.Meal_Info
import com.example.recipebazzar.Domain.Models.OnlineStore
import com.example.recipebazzar.Domain.NetworkUtils.NetworkEvents
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class StoresRepositoryImpl @Inject constructor(    private val  storeRef: CollectionReference): StoreRepository {


    override fun getOnlineStores(store_category: String) = callbackFlow {

        NetworkEvents.Loading<List<OnlineStore>>()

        val snapshotListener = storeRef
            .whereEqualTo("Category", store_category)
            .addSnapshotListener { snapshot, e ->

            val response = if (snapshot != null && e == null) {

                val stores = snapshot.toObjects(OnlineStore::class.java)


                if(stores.isNullOrEmpty()){
                    NetworkEvents.Error("Unable to load the data.")

                }else{
                    NetworkEvents.Success(stores)
                }


            } else {

                NetworkEvents.Error(e?.message ?: e.toString())

            }
            trySend(response)


        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}