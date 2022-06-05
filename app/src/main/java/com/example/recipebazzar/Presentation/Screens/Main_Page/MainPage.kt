package com.example.recipebazzar.Presentation.Screens.Main_Page

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipebazzar.MainActivity
import com.example.recipebazzar.Presentation.PublicPresentationEvents.PublicUiEvents


import com.example.recipebazzar.Presentation.Screens.Main_Page.Components.AppBottomItem
import com.example.recipebazzar.Presentation.Screens.Main_Page.Components.BottomAppBarMainPage
import com.example.recipebazzar.Presentation.Screens.Main_Page.Components.OnlineStores
import com.example.recipebazzar.Presentation.ui.ItemsUi.MealsCategory
import com.example.recipebazzar.Presentation.ui.theme.White11
import com.example.recipebazzar.R


import kotlinx.coroutines.flow.collect

@Composable
fun MainPage(
   onNavigate: (PublicUiEvents.Navigate) -> Unit,
   currentScreen: MutableState<AppBottomItem>,
   activity: Activity?
    ){



   val  viewModel: MainPageViewModel =  hiltViewModel()
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {

        scrollState.animateScrollTo(scrollState.value - 1000)
        viewModel.uiEvent.collect { event ->

            when(event){

                is PublicUiEvents.ShowSnackbar  -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )

                }

                is PublicUiEvents.CloseApp -> {

                       activity?.let {
                           activity.finish()
                       }

                }

                is PublicUiEvents.Navigate -> onNavigate(event);



                else -> Unit
            }

        }
    }


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp),
        scaffoldState = scaffoldState,
       bottomBar = {
            BottomAppBarMainPage( currentScreenId = currentScreen.value.id) {
                currentScreen.value= it
            }
                    }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
        ){

            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Happy MealBee",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 30.sp
                )
                Spacer(
                    modifier = Modifier.width(5.dp)
                )
                Image(
                    painter = painterResource(R.drawable.bee),
                    contentDescription = "",
                    modifier = Modifier.size(45.dp)
                )
            }


            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = "Online Stores",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = Color.DarkGray

            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )
            OnlineStores()

            Spacer(
                modifier = Modifier.height(15.dp)
            )


            Text(
                text = "Select Category",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = Color.DarkGray
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


@Preview(showBackground = true)
@Composable
fun PreviewPgage(){

  ///  MainPage(onNavigate =  {}, currentScreen = remember { mutableStateOf<AppBottomItem>(AppBottomItem.Home) } )
}







