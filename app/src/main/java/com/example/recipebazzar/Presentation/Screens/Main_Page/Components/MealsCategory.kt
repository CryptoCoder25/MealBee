package com.example.recipebazzar.Presentation.ui.ItemsUi

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageEvent
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageViewModel
import com.example.recipebazzar.Presentation.ui.theme.*
import com.example.recipebazzar.R


@Preview
@Composable
fun MealsCategory(
    viewModel: MainPageViewModel =  hiltViewModel()
){
        val configuration = LocalConfiguration.current
        var cardModifier: Modifier
        val cardElevation: Dp = 3.dp;
        val fontWeight = FontWeight.Normal;
        val fontColor = Color.DarkGray


         if(configuration.screenWidthDp.dp <= 480.dp)
         {
             cardModifier = Modifier
                 .fillMaxWidth()

         }else{

             cardModifier = Modifier
                 .padding(vertical = 8.dp, horizontal = 5.dp)
         }
       Log.d("SIZE",configuration.screenWidthDp.dp.toString())

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
                                .background(color = HotPink)
                                .padding(25.dp, 8.dp)

                        ) {


                            Image(
                                painter = painterResource(R.drawable.beef_item),
                                contentDescription = "",
                            )

                            Text(
                                text = "Beef",
                               fontWeight = fontWeight,
                                color = fontColor
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
                            viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Vegetarian"))
                        }
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .background(color = TiffanyBlue)
                                .padding(25.dp, 8.dp)

                        ) {

                            Image(
                                painter = painterResource(R.drawable.vegetarian_item),
                                contentDescription = "",
                            )

                            Text(
                                text = "Vegetarian",
                                fontWeight = fontWeight,
                                color = fontColor
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
                        .background(color = ClayMint)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.chicken_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Chicken",
                        fontWeight = fontWeight,
                        color = fontColor
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
                        .background(color = ClayYellow)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.pork_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Pork",
                        fontWeight = fontWeight,
                        color = fontColor
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
                        .background(color = ClayBlue)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.lamb_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Lamb",
                        fontWeight = fontWeight,
                        color = fontColor
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
                        .background(color = ClayViolet)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.pasta_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Pasta",
                        fontWeight = fontWeight,
                        color = fontColor
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
                    viewModel.MainPageEventVM(MainPageEvent.onClickCategory("Vegan"))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = Mint)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.vegan_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Vegan",
                        fontWeight = fontWeight,
                        color = fontColor
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
                        .background(color = ClaySpearMint)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.desert_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Dessert",
                        fontWeight = fontWeight,
                        color = fontColor
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
                        .background(color = HotPink)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.goat_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Goat",
                        fontWeight = fontWeight,
                        color =  fontColor
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
                        .background(color = TiffanyBlue)
                        .padding(25.dp, 8.dp)

                ) {


                    Image(
                        painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                    )

                    Text(
                        text = "Seafood",
                        fontWeight = fontWeight,
                        color = fontColor
                    )


                }


            }
        }



    }
}




