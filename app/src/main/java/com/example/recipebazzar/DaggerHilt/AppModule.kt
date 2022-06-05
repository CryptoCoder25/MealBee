package com.example.recipebazzar.DaggerHilt

import android.app.Application
import androidx.room.Room
import com.example.recipebazzar.Data.DataRepository.CheckListRepositoryImpl
import com.example.recipebazzar.Domain.NetworkUtils.ApiEndpoints
import com.example.recipebazzar.Domain.NetworkUtils.ApiUrls
import com.example.recipebazzar.Domain.DomainRepository.Repository
import com.example.recipebazzar.Data.DataRepository.RepositoryImpl
import com.example.recipebazzar.Data.DataRepository.StoresRepositoryImpl
import com.example.recipebazzar.Data.LocalDataSource.RoomDB
import com.example.recipebazzar.Domain.DomainRepository.ChecklistRepository
import com.example.recipebazzar.Domain.DomainRepository.StoreRepository
import com.example.recipebazzar.Utils.Constants.ROOT_COLLECTION
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiEndpoints {
        return Retrofit.Builder()
            .baseUrl(ApiUrls.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
            .build()
            .create(ApiEndpoints::class.java)
    }


    @Provides
    @Singleton
    fun provideRecipeRepository(api: ApiEndpoints): Repository {
        return RepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideLocalDb(app: Application): RoomDB{
        return Room.databaseBuilder(
            app,
           RoomDB::class.java,
            RoomDB.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCheckListNoteRepository(db: RoomDB): ChecklistRepository{
             return CheckListRepositoryImpl(db.noteDao)

    }


    //FIRESTORE DEPENDENCIES
    @Provides
    fun provideFirebaseFirestore() = Firebase.firestore

    @Provides
    fun provideStoresCollectionRef(db: FirebaseFirestore) = db.collection(ROOT_COLLECTION)

    @Provides
    fun provideStoresRepository(
        storesRef: CollectionReference
    ): StoreRepository = StoresRepositoryImpl(storesRef)
}