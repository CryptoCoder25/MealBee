package com.example.recipebazzar.Presentation.Screens.Main_Page.Components

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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageEvent
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageViewModel
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.UiConstant
import com.example.recipebazzar.Presentation.ui.theme.*
import com.example.recipebazzar.R


@Preview
@Composable
fun OnlineStores( viewModel: MainPageViewModel =  hiltViewModel()){


            val configuration = LocalConfiguration.current
            var cardModifier: Modifier

            Log.d("SIZE", configuration.screenWidthDp.dp.toString())


            val cardElevation: Dp = 3.dp;
            val textSize = 13.sp;
            if (configuration.screenWidthDp.dp <= 480.dp) {

                cardModifier = Modifier
                    .fillMaxWidth()

            } else {

                cardModifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 5.dp)
            }



    Row(modifier = Modifier.padding(horizontal = 20.dp)) {

        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(8),
                elevation = cardElevation,
                modifier = cardModifier.clickable{
                    viewModel.MainPageEventVM(MainPageEvent.onClickStore(UiConstant.StoreCategory.ingredients_store))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = ClayMint)
                        .padding(5.dp,5.dp)

                ) {


                    Image( painter = painterResource(R.drawable.ingredients),
                        contentDescription = "",
                        modifier = Modifier.padding(10.dp))

                    Text(
                        text = "Ingredients",
                        fontSize = textSize
                    )


                }


            }
        }


        Spacer(
            modifier = Modifier
                .width(10.dp)
        )

        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(8),
                elevation = cardElevation,
                modifier = cardModifier.clickable{
                    viewModel.MainPageEventVM(MainPageEvent.onClickStore(UiConstant.StoreCategory.beverage_store))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = HotPink)
                        .padding(5.dp,5.dp)

                ) {


                    Image( painter = painterResource(R.drawable.beverage),
                        contentDescription = "",
                        modifier = Modifier.padding(10.dp))

                    Text(
                        text = "Beverage",
                        fontSize = textSize
                    )


                }


            }
        }

        Spacer(
            modifier = Modifier
                .width(10.dp)
        )

        Box(modifier = Modifier.weight(1f)) {
            Card(
                shape = RoundedCornerShape(8),
                elevation = cardElevation,
                modifier = cardModifier.clickable{
                    viewModel.MainPageEventVM(MainPageEvent.onClickStore(UiConstant.StoreCategory.kitchenware_store))
                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = ClayBlue)
                        .padding(5.dp,5.dp)

                ) {


                    Image( painter = painterResource(R.drawable.kitchen),
                        contentDescription = "",
                        modifier = Modifier.padding(10.dp))

                    Text(
                        text = "Kitchenware",
                        fontSize = textSize
                    )


                }


            }
        }

    }

}

