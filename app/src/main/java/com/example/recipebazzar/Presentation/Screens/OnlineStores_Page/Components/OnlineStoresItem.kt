package com.example.recipebazzar.Presentation.Screens.OnlineStores_Page.Components

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.recipebazzar.Domain.Models.OnlineStore
import com.example.recipebazzar.R





@Composable
fun OnlineStoreItem(
    store: OnlineStore,
    brush: Brush,
){
    val uriHandler = LocalUriHandler.current
    Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .clickable {
                    try {
                       uriHandler.openUri(store.Website)
                    } catch (e: Exception) {
                        //  L.e(e, "Failed to open uri")
                        Log.d("OnlineStoreClick", e.localizedMessage.toString())
                    }
                },
            shape = RoundedCornerShape(5.dp),
            elevation = 1.dp,
        ) {

            Column()
            {
                Image(
                    modifier = Modifier
                        .background(brush)
                        .fillMaxWidth()
                        .height(150.dp),
                    painter = rememberImagePainter(store.ImageLink),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth

                )


                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 5.dp),
                        fontWeight = FontWeight.SemiBold,
                        text = store.StoreName,
                        style = MaterialTheme.typography.h6
                    )



                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, bottom = 5.dp),
                        fontWeight = FontWeight.Light,
                        text = store.Description,
                        fontSize = 15.sp
                    )



            }


        }









}


