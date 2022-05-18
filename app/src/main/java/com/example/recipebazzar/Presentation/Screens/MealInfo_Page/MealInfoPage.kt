package com.example.recipebazzar.Presentation.Screens.MealInfo_Page

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.recipebazzar.Domain.Models.Meal_Info
import com.example.recipebazzar.Presentation.PublicEvents.PublicUiEvents
import com.example.recipebazzar.Presentation.Screens.MealInfo_Page.Components.MealInfoItemsFormatter
import com.example.recipebazzar.Presentation.Screens.MealsList_Page.MealsListViewModel
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.ItemMealInfoShimmerEffect
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.LoadingAnimation1
import com.example.recipebazzar.Presentation.ui.theme.*
import com.example.recipebazzar.R
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MealInfoPage(
    onNavigate: (PublicUiEvents.Navigate) -> Unit,
    viewModel: Meal_InfoViewModel =  hiltViewModel()
){

    val scaffoldState = rememberScaffoldState()
    val state =   viewModel.state.value
    var mealdata : Meal_Info? = null


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
        if (mealdata != null) {
            Column(modifier = Modifier.fillMaxSize()) {
                ParallaxToolbar(mealdata)
                ButtonContainer(mealdata)
                Box(
                    modifier = Modifier
                        .fillMaxSize(1F)
                        .padding(top = 15.dp)
                ) {
                    val list =
                        MealInfoItemsFormatter.getIngredients(mealdata) + ((0..100).map { it.toString() })
                    var x: Int = 0;

                    LazyVerticalGrid(
                        cells = GridCells.Fixed(2),
                        // content padding
                        contentPadding = PaddingValues(
                            start = 25.dp,
                            end = 25.dp,
                            bottom = 20.dp
                        ),
                        content = {

                            items(MealInfoItemsFormatter.getIngredients(mealdata).size) { index ->

                                if (!MealInfoItemsFormatter.getIngredients(mealdata)[index].isNullOrEmpty() ||
                                    !MealInfoItemsFormatter.getIngredients(mealdata)[index].toString()
                                        .equals("")
                                ) {
                                    var ingriedient =
                                        MealInfoItemsFormatter.getIngredients(mealdata)[index];
                                    var measurement =
                                        MealInfoItemsFormatter.getMeasurements(mealdata)[index];

                                    ItemMealInfoShimmerEffect(ingriedient, measurement)

                                }

                            }
                        }
                    )


                }
            }
        }
    }


}