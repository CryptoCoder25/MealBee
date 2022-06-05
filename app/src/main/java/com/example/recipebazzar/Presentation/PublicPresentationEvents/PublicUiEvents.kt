package com.example.recipebazzar.Presentation.PublicPresentationEvents

sealed class PublicUiEvents {

    object PopBackStack :PublicUiEvents()

    object CloseApp :PublicUiEvents()

    data class Navigate(val route: String): PublicUiEvents()

    data class ShowSnackbar(
        val message: String,
        val action: String? = null
    ): PublicUiEvents()

    data class ShowToastMessage(
        val message: String,
        val action: String? = null
    ): PublicUiEvents()


}
