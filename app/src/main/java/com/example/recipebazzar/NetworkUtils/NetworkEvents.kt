package com.example.recipebazzar.NetworkUtils

sealed class NetworkEvents<T>(val data: T? = null, val message: String? = null)  {

        class Success<T>(data: T) : NetworkEvents<T>(data)
        class Error<T>(message: String, data: T? = null) : NetworkEvents<T>(data, message)
        class Loading<T>(data: T? = null) :NetworkEvents<T>(data)

}