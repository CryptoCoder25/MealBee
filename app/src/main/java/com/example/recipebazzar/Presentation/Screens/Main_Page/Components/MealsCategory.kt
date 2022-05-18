package com.example.recipebazzar.Presentation.ui.ItemsUi

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipebazzar.R
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageEvent
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageViewModel
import com.example.recipebazzar.Presentation.ui.theme.*


@Preview
@Composable
fun MealsCategory(
    viewModel: MainPageViewModel =  hiltViewModel()
){
        val configuration = LocalConfiguration.current
        var cardModifier: Modifier

        Log.d("SIZE",configuration.screenWidthDp.dp.toString())


        val cardElevation: Dp = 3.dp;
         if(configuration.screenWidthDp.dp <= 480.dp)
         {
             cardModifier = Modifier
                 .fillMaxWidth()

         }else{

             cardModifier = Modifier
                 .padding(vertical = 8.dp, horizontal = 5.dp)
         }


            Row() {

                Box(modifier = Modifier.weight(1f)) {
                    Card(
                        shape = RoundedCornerShape(8),
                        elevation = cardElevation,
                        modifier = cardModifier.clickable {
                            viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Beef"))
                        }
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .background(color = TCOLOR22)
                                .padding(25.dp, 8.dp)

                        ) {


                            Image(
                                painter = painterResource(R.drawable.seafoods_item),
                                contentDescription = "",
                            )

                            Text(
                                text = "Beef",
                               fontWeight = FontWeight.SemiBold
                            )


                        }


                    }
                }


                Spacer(
                    modifier = Modifier
                        .width(15.dp)
                )
                Box(modifier = Modifier.weight(1f)) {
                    Card(
                        shape = RoundedCornerShape(8),
                        elevation = cardElevation,
                        modifier = cardModifier.clickable {
                            viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Pork"))
                        }
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .background(color = TCOLOR22)
                                .padding(25.dp, 8.dp)

                        ) {


                            Image(
                                painter = painterResource(R.drawable.seafoods_item),
                                contentDescription = "",
                            )

                            Text(
                                text = "Pork",
                                fontWeight = FontWeight.SemiBold
                            )


                        }


                    }
                }



            }

    Spacer(
        modifier = Modifier.height(15.dp)
    )
    Row() {

        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(8),
                elevation = cardElevation,
                modifier = cardModifier.clickable {
                    viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Chicken"))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = TCOLOR22)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Chicken",
                        fontWeight = FontWeight.SemiBold
                    )


                }


            }
        }


        Spacer(
            modifier = Modifier
                .width(15.dp)
        )
        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(8),
                elevation = cardElevation,
                modifier = cardModifier.clickable {
                    viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Seafood"))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = TCOLOR22)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Seafood",
                        fontWeight = FontWeight.SemiBold
                    )


                }


            }
        }



    }

    Spacer(
        modifier = Modifier.height(15.dp)
    )
    Row() {

        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(8),
                elevation = cardElevation,
                modifier = cardModifier.clickable {
                    viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Lamb"))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = TCOLOR22)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Lamb",
                        fontWeight = FontWeight.SemiBold
                    )


                }


            }
        }


        Spacer(
            modifier = Modifier
                .width(15.dp)
        )
        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(8),
                elevation = cardElevation,
                modifier = cardModifier.clickable {
                    viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Pasta"))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = TCOLOR22)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Pasta",
                        fontWeight = FontWeight.SemiBold
                    )


                }


            }
        }



    }
    Spacer(
        modifier = Modifier.height(15.dp)
    )
    Row() {

        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(8),
                elevation = cardElevation,
                modifier = cardModifier.clickable {
                    viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Vegetarian"))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = TCOLOR22)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Vegetarian",
                        fontWeight = FontWeight.SemiBold
                    )


                }


            }
        }


        Spacer(
            modifier = Modifier
                .width(15.dp)
        )
        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(8),
                elevation = cardElevation,
                modifier = cardModifier.clickable {
                    viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Dessert"))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = TCOLOR22)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Dessert",
                        fontWeight = FontWeight.SemiBold
                    )


                }


            }
        }



    }
    Spacer(
        modifier = Modifier.height(15.dp)
    )
    Row() {

        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(8),
                elevation = cardElevation,
                modifier = cardModifier.clickable {
                    viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Goat"))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = TCOLOR22)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Goat",
                        fontWeight = FontWeight.SemiBold
                    )


                }


            }
        }


        Spacer(
            modifier = Modifier
                .width(15.dp)
        )
        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(8),
                elevation = cardElevation,
                modifier = cardModifier.clickable {
                    viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Vegan"))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = TCOLOR22)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Vegan",
                        fontWeight = FontWeight.SemiBold
                    )


                }


            }
        }



    }
}




