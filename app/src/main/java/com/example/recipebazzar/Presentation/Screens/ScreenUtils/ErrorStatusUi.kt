package com.example.recipebazzar.Presentation.Screens.ScreenUtils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recipebazzar.R



@Composable
fun OnErrorView(message: String){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
              modifier = Modifier.padding(horizontal = 10.dp)) {

            Image( painter = painterResource(R.drawable.cloud),
                modifier = Modifier.size(100.dp),
                contentDescription = "")

            Text(
                text =  message,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                color = Color.LightGray
            )
        }
    }
}


@Composable
fun OnBlankView( message: String){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 10.dp)) {

            Image( painter = painterResource(R.drawable.blank_data),
                modifier = Modifier.size(100.dp),
                contentDescription = "")

            Text(
                text = message,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                color = Color.LightGray
            )
        }
    }
}