package com.example.recipebazzar.Presentation.Screens.MealsList_Page

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipebazzar.Presentation.PublicEvents.PublicUiEvents
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageViewModel
import com.example.recipebazzar.Presentation.Screens.MealInfo_Page.MealInfoStates
import com.example.recipebazzar.Presentation.Screens.MealsList_Page.Component.MealListItem
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.ItemMealShimmerEffect
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.LoadingAnimation1
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MealsListPage(
    onNavigate: (PublicUiEvents.Navigate) -> Unit,
    viewModel: MealsListViewModel =  hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()
    val state =   viewModel.state.value

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->

            when(event){

                is PublicUiEvents.ShowSnackbar  -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )

                }

                is PublicUiEvents.Navigate -> onNavigate(event);

                else -> Unit
            }

        }
    }

   if(state.isLoading){
       Box(modifier = Modifier.fillMaxSize(),
           contentAlignment = Alignment.Center){
           LoadingAnimation1()
       }
   }else if(state.error.isNotBlank()){


   } else {
       Scaffold(modifier = Modifier.fillMaxSize())
       {
           Column(modifier = Modifier.fillMaxWidth()) {

               Text(
                   fontSize = 26.sp,
                   fontWeight = FontWeight.SemiBold,
                   text = "Select Your Meal", modifier = Modifier
                       .fillMaxWidth()
                       .padding(20.dp)
               )

               Box(modifier = Modifier.fillMaxSize())
               {

                   LazyVerticalGrid(
                       cells = GridCells.Fixed(2),
                       // content padding
                       contentPadding = PaddingValues(
                           start = 12.dp,
                           end = 12.dp,
                           bottom = 16.dp
                       ),
                       content = {
                           items(state.meals) { index ->
                               ItemMealShimmerEffect(meal = index)
                           }
                       }
                   )


               }
           }

       }

   }
}




