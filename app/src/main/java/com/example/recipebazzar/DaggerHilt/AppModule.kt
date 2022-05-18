package com.example.recipebazzar.DaggerHilt

import com.example.recipebazzar.NetworkUtils.ApiEndpoints
import com.example.recipebazzar.NetworkUtils.ApiUrls
import com.example.recipebazzar.Domain.Repositories.Repository
import com.example.recipebazzar.Domain.Repositories.RepositoryImplementation
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
    fun provideCoinRepository(api: ApiEndpoints): Repository {
        return RepositoryImplementation(api)
    }



}