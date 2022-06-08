package com.example.recipebazzar.Presentation.Screens.MealInfo_Page

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipebazzar.Domain.Models.Meal_Info
import com.example.recipebazzar.Presentation.PublicPresentationEvents.PublicUiEvents
import com.example.recipebazzar.Presentation.Screens.MealInfo_Page.Components.MealInfoItemsFormatter
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.ItemMealInfoShimmerEffect
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.LoadingEffect
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.OnBlankView
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.OnErrorView
import com.example.recipebazzar.R
import kotlinx.coroutines.flow.collect

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MealInfoPage(
    onPopBackStack: () -> Unit,
    viewModel: Meal_InfoViewModel =  hiltViewModel()
){


    var mealdata : Meal_Info? = null;
    val scaffoldState = rememberScaffoldState()

    val state =   viewModel.state.value

         if (!state.mealinfo.isNullOrEmpty()) {
             mealdata = state.mealinfo.get(0);
         }

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->

            when(event){

                is PublicUiEvents.ShowSnackbar  -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )

                }

                is PublicUiEvents.PopBackStack -> onPopBackStack()



                else -> Unit
            }

        }
    }

    if(state.isLoading){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            LoadingEffect()
        }
    }else if(state.error.isNotBlank()){

        OnErrorView(state.error)

    } else {
        if (mealdata != null) {
            Column(modifier = Modifier.fillMaxSize()) {
                ParallaxToolbar(mealdata, viewModel)
                ButtonContainer(mealdata)
                Box(
                    modifier = Modifier
                        .fillMaxSize(1F)
                        .padding(top = 15.dp)
                ) {
                    LazyVerticalGrid(
                        cells = GridCells.Fixed(2),
                        // content padding
                        contentPadding = PaddingValues(
                            start = 25.dp,
                            end = 25.dp,
                            bottom = 20.dp
                        ),
                        content = {

                            items(MealInfoItemsFormatter.getMeasurements(mealdata).size) { index ->

                                var ingriedient = MealInfoItemsFormatter.getIngredients(mealdata)[index];
                                var measurement = MealInfoItemsFormatter.getMeasurements(mealdata)[index];

                                if (measurement.toString().isNullOrEmpty() ||
                                    measurement.toString().trim().equals("")||
                                    measurement.toString().trim().equals("null")

                                ) {

                                    Log.d("ITEM-VALUE-ERROR", measurement.toString())

                                }else{
                                    Log.d("ITEM-VALUE-SUCCESS", measurement.toString())
                                    ItemMealInfoShimmerEffect(ingriedient, measurement)
                                }

                            }
                        }
                    )


                }
            }
        }else {

            OnBlankView(message = "No Record Found!")
        }
    }


}