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
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageEvent
import com.example.recipebazzar.Presentation.ui.theme.BG3
import com.example.recipebazzar.Presentation.ui.theme.TCOLOR22
import com.example.recipebazzar.Presentation.ui.theme.TCOLOR223
import com.example.recipebazzar.R


@Preview
@Composable
fun OnlineStores(){


            val configuration = LocalConfiguration.current
            var cardModifier: Modifier

            Log.d("SIZE", configuration.screenWidthDp.dp.toString())


            val cardElevation: Dp = 3.dp;
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

                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = TCOLOR22)
                        .padding(10.dp,5.dp)

                ) {


                    Image( painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                        modifier = Modifier.padding(5.dp))

                    Text(
                        text = "Beef"
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

                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = BG3)
                        .padding(10.dp,5.dp)

                ) {


                    Image( painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                        modifier = Modifier.padding(5.dp))

                    Text(
                        text = "Beef"
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

                }
            ) {

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = TCOLOR223)
                        .padding(10.dp,5.dp)

                ) {


                    Image( painter = painterResource(R.drawable.seafoods_item),
                        contentDescription = "",
                        modifier = Modifier.padding(5.dp))

                    Text(
                        text = "Beef"
                    )


                }


            }
        }

    }

}

