package com.example.recipebazzar.Presentation.Screens.MealInfo_Page

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.recipebazzar.Domain.Models.Meal_Info
import com.example.recipebazzar.Presentation.Screens.ScreenUtils.IconButton1
import com.example.recipebazzar.Presentation.ui.theme.*
import com.example.recipebazzar.Utils.Constants.AppBarCollapsedHeight
import com.example.recipebazzar.Utils.Constants.AppBarExpendedHeight
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import kotlin.math.max
import kotlin.math.min
import com.example.recipebazzar.R



@Composable
fun ParallaxToolbar(data: Meal_Info) {

    val scrollState = rememberLazyListState()
    val imageHeight = AppBarExpendedHeight - AppBarCollapsedHeight

    val maxOffset = with(LocalDensity.current) { imageHeight.roundToPx() } -
                LocalWindowInsets.current.systemBars.layoutInsets.top

    val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)

    val offsetProgress = max(0f, offset * 3f - 2f * maxOffset) / maxOffset

    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = White,
        modifier = Modifier
            .height(
                AppBarExpendedHeight
            )
            .offset { IntOffset(x = 0, y = -offset) },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
    ) {
        Column {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .height(AppBarCollapsedHeight)
                    .padding(horizontal = 16.dp)
            ) {
                IconButton1(R.drawable.ic_baseline_arrow_back)

                Text(
                    data.strArea.toString(),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = (16 + 28 * offsetProgress).dp)
                        .scale(1f - 0.25f * offsetProgress)
                )

                IconButton1(R.drawable.ic_baseline_share)
            }
            Box(
                Modifier
                    .height(imageHeight)
                    .graphicsLayer {
                        alpha = 1f - offsetProgress
                    }) {
           Card(  modifier = Modifier
               .fillMaxWidth()
               .padding(25.dp, 15.dp),
               shape = RoundedCornerShape(5.dp),
               elevation = 3.dp,) {
               Image(
                   painter = rememberImagePainter(data.strMealThumb),
                   contentDescription = null,
                   contentScale = ContentScale.FillWidth,
                   modifier = Modifier
                       .fillMaxWidth()
               )
               Box(   modifier = Modifier
                   .fillMaxSize()
                   .padding(10.dp),
                   contentAlignment = Alignment.BottomStart) {
                   Text(
                       modifier = Modifier.background(Transparent_dark),
                       fontWeight = FontWeight.Bold,
                       text = data.strMeal.toString(),
                       style = TextStyle(color = White11, fontSize = 20.sp)
                   )
               }

           }

            }

        }
    }


}


@Composable
fun ButtonContainer(mealInfo: Meal_Info){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
    ) {

        Text(
            "Ingredients",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Row(){
            val uriHandler = LocalUriHandler.current
            OutlinedButton(
                modifier = Modifier.padding(end = 3.dp),
                onClick = {
                    try {
                        uriHandler.openUri(mealInfo.strYoutube.toString())
                    } catch (e: Exception) {
                      //  L.e(e, "Failed to open uri")
                        Log.d("MealInfoData", e.localizedMessage.toString())
                    } }
            ) {
                Icon(Icons.Default.PlayArrow,contentDescription = null)
                Text("Instruction")
            }

        }


    }
}

@Composable
fun IngredientItemCard(ingredientName: String?, measurement: String?, brush: Brush) {

        Card(
            elevation = 0.dp,
            backgroundColor = LightGray,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(vertical = 3.dp, horizontal = 3.dp)

        ) {
           Row(
               modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberImagePainter("https://www.themealdb.com/images/ingredients/${ingredientName}-Small.png"),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(start = 3.dp)

                )

                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = ingredientName.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold

                    )
                    Text(
                        text = measurement.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal

                    )
                }
            }
        }


}



