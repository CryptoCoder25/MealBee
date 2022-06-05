package com.example.recipebazzar.Presentation.Screens.Main_Page

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipebazzar.Presentation.PublicPresentationEvents.PublicUiEvents
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.UiConstant
import com.example.recipebazzar.Utils.Routes
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainPageViewModel @Inject constructor(): ViewModel() {

    private val _uiEvent =  Channel<PublicUiEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun MainPageEventVM(event: MainPageEvent){

         when(event){

             is MainPageEvent.onClickCategory ->{
                 sendUiEvent(PublicUiEvents.Navigate(Routes.MealListScreen + "?category=${event.category}"))
             }


             is MainPageEvent.onClickAppBarItem ->{
                 Log.d("ITEM_BAR",event.itemId);

                 if(event.itemId.equals(UiConstant.MainPageAppBarItemId.home))
                 {
                     sendUiEvent(PublicUiEvents.Navigate(Routes.MainScreen))

                 }else if(event.itemId.equals(UiConstant.MainPageAppBarItemId.checklist)){

                     sendUiEvent(PublicUiEvents.Navigate(Routes.CheckListNoteScreen))

                 } else if(event.itemId.equals(UiConstant.MainPageAppBarItemId.scheduledmeal)){

                     sendUiEvent(PublicUiEvents.Navigate(Routes.ScheduledMealScreen))

                 } else if(event.itemId.equals(UiConstant.MainPageAppBarItemId.exit)){

                     sendUiEvent(PublicUiEvents.CloseApp)
                     //sendUiEvent(PublicUiEvents.Navigate(Routes.ScheduledMealScreen))

                 }
             }


           is MainPageEvent.onClickStore -> {

               if(event.store_category.equals(UiConstant.StoreCategory.ingredients_store))
               {
                   sendUiEvent(PublicUiEvents.Navigate(Routes.OnlineStoreScreen + "?STORE_CATEGORY=${event.store_category}"))
               } else if (event.store_category.equals(UiConstant.StoreCategory.beverage_store)){

                   sendUiEvent(PublicUiEvents.Navigate(Routes.OnlineStoreScreen + "?STORE_CATEGORY=${event.store_category}"))

               } else if(event.store_category.equals(UiConstant.StoreCategory.kitchenware_store)) {
                   sendUiEvent(PublicUiEvents.Navigate(Routes.OnlineStoreScreen + "?STORE_CATEGORY=${event.store_category}"))

               } else{
                   Log.d("UNDEFINED_STORE",event.store_category);
               }
           }




         }

    }

    private fun sendUiEvent(event: PublicUiEvents) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}