package com.example.recipebazzar.Presentation.Screens.MealsList_Page.Component

import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.recipebazzar.Domain.Models.Meal
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageEvent
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageViewModel
import com.example.recipebazzar.Presentation.Screens.MealsList_Page.MealsListEvents
import com.example.recipebazzar.Presentation.Screens.MealsList_Page.MealsListViewModel
import com.example.recipebazzar.Presentation.ui.theme.*
import com.example.recipebazzar.R





@Composable
fun MealListItem(
    meal: Meal,
    brush: Brush,
    viewModel: MealsListViewModel =  hiltViewModel()
){



    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .clickable { viewModel.OnEvent(MealsListEvents.onClickMealItem(meal.MealId)) },
        shape = RoundedCornerShape(5.dp),
        elevation = 3.dp,
    ) {

        Box(modifier = Modifier.height(100.dp))
        {
            Image(
                modifier = Modifier.fillMaxWidth().background(brush),
                painter = rememberImagePainter(meal.MealImage),
                contentDescription = null,
                contentScale = ContentScale.FillWidth

            )
            Box(   modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
                contentAlignment = Alignment.BottomStart) {
                Text(
                    fontWeight = FontWeight.Bold,
                    text = meal.MealName,
                    style = TextStyle(color = White11, fontSize = 16.sp)
                )
            }
        }


    }

}






