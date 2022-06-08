package com.example.recipebazzar.Presentation.Screens.BMICalculatore_Page

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipebazzar.Presentation.PublicPresentationEvents.PublicUiEvents
import com.example.recipebazzar.Presentation.Screens.BMICalculatore_Page.Components.BmiResult
import com.example.recipebazzar.Presentation.Screens.BMICalculatore_Page.Components.GenderButton
import com.example.recipebazzar.Presentation.Screens.BMICalculatore_Page.Components.HeightField
import com.example.recipebazzar.Presentation.Screens.BMICalculatore_Page.Components.WeightandAgeFields
import com.example.recipebazzar.R
import kotlin.text.Typography


@Preview
@Composable
fun BMICalculatorPage(
    viewModel: BMICalculatorViewModel = hiltViewModel()
){
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {

                is PublicUiEvents.ShowToastMessage -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }

                else -> Unit
            }
        }
    }

    var weight = remember { mutableStateOf("0") }
    var height = remember { mutableStateOf("0") }
    var age = remember { mutableStateOf("0") }

    val configuration = LocalConfiguration.current
    var cardModifier: Modifier

    Log.d("SIZE", configuration.screenWidthDp.dp.toString())


    val cardElevation: Dp = 3.dp;
    if (configuration.screenWidthDp.dp <= 480.dp) {

        cardModifier = Modifier.fillMaxWidth()

    } else {

        cardModifier = Modifier.fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 5.dp)
    }



    Column(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 20.dp),
         horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "BMI CALCULATOR",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Medium
        )


        Spacer(modifier = Modifier.height(30.dp))
        GenderButton(cardModifier,cardElevation,viewModel)
        Spacer(modifier = Modifier.height(30.dp))
        HeightField(cardModifier,cardElevation,height,viewModel)
        Spacer(modifier = Modifier.height(30.dp))
        WeightandAgeFields(cardModifier, cardElevation,age,weight,viewModel)
        Spacer(modifier = Modifier.height(40.dp))
        BmiResult(viewModel)
        Button( modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            onClick = {
                viewModel.onEvent(BMICalculatorEvents.OnClickCalculate)
            }) {
            Text(
                text = "CALCULATE",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold
            )
        }


    }





}


