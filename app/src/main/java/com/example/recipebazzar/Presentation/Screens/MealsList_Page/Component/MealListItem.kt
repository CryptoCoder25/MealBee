package com.example.recipebazzar.Presentation.Screens.MealsList_Page.Component

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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.recipebazzar.Domain.Models.Meal
import com.example.recipebazzar.Presentation.Screens.MealsList_Page.MealsListEvents
import com.example.recipebazzar.Presentation.Screens.MealsList_Page.MealsListViewModel
import com.example.recipebazzar.Presentation.ui.theme.Transparent_dark
import com.example.recipebazzar.Presentation.ui.theme.White


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
                    modifier = Modifier.background(Transparent_dark),
                    fontWeight = FontWeight.SemiBold,
                    text = meal.MealName,
                    style = TextStyle(color = White, fontSize = 16.sp)
                )
            }
        }


    }

}






