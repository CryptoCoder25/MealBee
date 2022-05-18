package com.example.recipebazzar.Presentation.PublicEvents

sealed class PublicUiEvents {

    object PopBackStack:PublicUiEvents()
    data class Navigate(val route: String): PublicUiEvents()
    data class ShowSnackbar(
        val message: String,
        val action: String? = null
    ): PublicUiEvents()


}
