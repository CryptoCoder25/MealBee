package com.example.recipebazzar.Presentation.Screens.OnlineStores_Page

import com.example.recipebazzar.Presentation.Screens.MealsList_Page.MealsListViewModel


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipebazzar.Presentation.PublicPresentationEvents.PublicUiEvents
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.*
import com.example.recipebazzar.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnlineStorePage(
    onNavigate: (PublicUiEvents.Navigate) -> Unit,
    viewModel: OnlineStoreViewModel =  hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()
    val state = viewModel.state.value


    if(state.isLoading){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            LoadingEffect()
        }
    }else if(state.error.isNotBlank()){

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

                    Card(
                        shape = RoundedCornerShape(5.dp),
                        elevation = 3.dp
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, end = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Online Stores",
                                style = MaterialTheme.typography.h5,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.DarkGray
                            )
                            Image(
                                painter = painterResource(R.drawable.online_store),
                                contentDescription = "",
                                modifier = Modifier.padding(10.dp)
                            )

                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 10.dp, end = 10.dp)
                    )
                    {


                        LazyColumn {
                            items(state.stores) { index ->
                                ItemStoreShimmerEffect(index)
                            }
                        }


                    }
                }

            }




    }
}




