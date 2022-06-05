package com.example.recipebazzar.Domain.Utils

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}