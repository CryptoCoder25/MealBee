package com.example.recipebazzar.Presentation.Screens.Main_Page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipebazzar.Presentation.PublicEvents.PublicUiEvents
import com.example.recipebazzar.Presentation.Screens.Main_Page.Components.BottomAppBar1

import com.example.recipebazzar.Presentation.Screens.Main_Page.Components.AppBottomItem
import com.example.recipebazzar.Presentation.Screens.Main_Page.Components.OnlineStores
import com.example.recipebazzar.Presentation.ui.ItemsUi.MealsCategory

import kotlinx.coroutines.flow.collect



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainPage(
   onNavigate: (PublicUiEvents.Navigate) -> Unit,
   currentScreen: MutableState<AppBottomItem>
    ){

   val  viewModel: MainPageViewModel =  hiltViewModel()
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState()



    LaunchedEffect(key1 = true) {
        // scrollState.scrollTo()
        scrollState.animateScrollTo(scrollState.value - 1000)
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


    Scaffold(
        bottomBar = {
            BottomAppBar1( currentScreenId = currentScreen.value.id) {
                currentScreen.value= it
            }
                    },
        drawerContent = { Text(text = "Drawer") }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, start = 20.dp, end = 20.dp)
        ){

            Text(
                text = "Welcome to MealBoi",
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
                style = MaterialTheme.typography.h6,
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "ONLINE STORES",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp

            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )
            OnlineStores()

            Spacer(
                modifier = Modifier.height(10.dp)
            )


            Text(
                text = "MEAL CATEGORIES",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp

            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )


            Column(modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(bottom = 70.dp)
                .padding(horizontal = 10.dp)) {
                MealsCategory()
            }

        }
    }


}




