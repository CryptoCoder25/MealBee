package com.example.recipebazzar.Presentation.Screens.MealsList_Page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipebazzar.Presentation.PublicPresentationEvents.PublicUiEvents
import com.example.recipebazzar.Presentation.Screens.CheckListNote_Page.CheckListNoteEvent
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.ItemMealShimmerEffect
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.LoadingEffect
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.OnErrorView
import com.example.recipebazzar.R
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

                is PublicUiEvents.Navigate -> onNavigate(event);

                else -> Unit
            }

        }
    }

   if(state.isLoading){

       Box(modifier = Modifier.fillMaxSize(),
           contentAlignment = Alignment.Center)
       {
           LoadingEffect()
       }

   } else if(state.error.isNotBlank()){

       OnErrorView(state.error)

   } else {

       Scaffold(
           modifier = Modifier
               .fillMaxSize()
               .padding(top = 15.dp),
           scaffoldState = scaffoldState,
       )
       {
           Column(modifier = Modifier.fillMaxWidth()) {

               Card(  shape = RoundedCornerShape(5.dp),
                   elevation = 3.dp) {
                   Row(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(start = 15.dp, end = 10.dp),
                       horizontalArrangement = Arrangement.SpaceBetween,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Text(
                           text = "Menu List",
                           style = MaterialTheme.typography.h5,
                           fontWeight = FontWeight.SemiBold,
                           color = Color.DarkGray
                       )
                       Image( painter = painterResource(R.drawable.cook),
                           contentDescription = "",
                           modifier = Modifier.padding(10.dp))

                   }
               }

               Spacer(modifier = Modifier.height(8.dp))
               Box(modifier = Modifier
                   .fillMaxSize()
                   .padding(start = 10.dp, end = 10.dp))
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




