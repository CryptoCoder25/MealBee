package com.example.recipebazzar.Presentation.Screens.BMICalculatore_Page.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipebazzar.Presentation.Screens.BMICalculatore_Page.BMICalculatorEvents
import com.example.recipebazzar.Presentation.Screens.BMICalculatore_Page.BMICalculatorViewModel
import com.example.recipebazzar.Presentation.ui.theme.*
import com.example.recipebazzar.R


@Composable
fun GenderButton(cardModifier: Modifier, cardElevation: Dp){

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)) {

        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(5),
                elevation = cardElevation,
                modifier = cardModifier.clickable{

                }
            ) {
                Column( verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.background(color = TiffanyBlue)
                        .padding(5.dp,30.dp))
                {
                    Image(
                        painter = painterResource(R.drawable.male),
                        contentDescription = "")
                }


            }
        }

        Spacer(
            modifier = Modifier
                .width(10.dp)
        )

        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(5),
                elevation = cardElevation,
                modifier = cardModifier.clickable{

                }
            ) {
                Column( verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.background(color = HotPink)
                        .padding(5.dp,30.dp))
                {
                    Image(
                        painter = painterResource(R.drawable.female),
                        contentDescription = "")
                }


            }
        }



    }
}


@Composable
fun HeightField(cardModifier: Modifier, cardElevation: Dp,
                viewModel: BMICalculatorViewModel){

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)) {
        Card(
            shape = RoundedCornerShape(5),
            elevation = cardElevation,
            modifier = cardModifier
        ) {
            Column( verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(color = ClayYellow)
                    .padding(10.dp,20.dp))
            {
                Text(
                    text = "HEIGHT (CM)",
                    fontWeight = FontWeight.Normal,
                    style =  MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                BasicTextField(
                    value =  viewModel.height,
                    onValueChange = { viewModel.onEvent(BMICalculatorEvents.OnHeightChange(it)) },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    textStyle = TextStyle(fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center)
                )

            }


        }
    }
}


@Composable
fun WeightandAgeFields(cardModifier: Modifier,
                       cardElevation: Dp ,
                       viewModel: BMICalculatorViewModel
                       ){




    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)) {
        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(5),
                elevation = cardElevation,
                modifier = cardModifier
            ) {
                Column( verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth().background(color = ClayViolet)
                        .padding(10.dp,20.dp))
                {
                    Text(
                        text = "WEIGHT (KG)",
                        fontWeight = FontWeight.Normal,
                        style =  MaterialTheme.typography.h6,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )


                    BasicTextField(
                        value = viewModel.weight,
                        onValueChange = { viewModel.onEvent(BMICalculatorEvents.OnWeightChange(it)) },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        textStyle = TextStyle(fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            textAlign = TextAlign.Center)
                    )
                }


            }
        }

        Spacer(modifier = Modifier.width(15.dp))

        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(5),
                elevation = cardElevation,
                modifier = cardModifier
            ) {
                Column( verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth().background(color = ClayMint)
                        .padding(10.dp,20.dp))
                {
                    Text(
                        text = "AGE",
                        fontWeight = FontWeight.Normal,
                        style =  MaterialTheme.typography.h6,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    BasicTextField(
                        value = viewModel.age,
                        onValueChange = {viewModel.onEvent(BMICalculatorEvents.OnAgeChange(it)) },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        textStyle = TextStyle(fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            textAlign = TextAlign.Center)
                    )
                }


            }
        }
    }
}


@Composable
fun BmiResult(viewModel: BMICalculatorViewModel){


    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp,20.dp)) {

        Text(
            text = "Your BMI (${viewModel.bmistatus.value})",
            fontWeight = FontWeight.SemiBold,
            style =  MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = viewModel.bmi.value,
            fontWeight = FontWeight.SemiBold,
            style =  MaterialTheme.typography.h3,
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }

}