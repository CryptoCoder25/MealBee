package com.example.recipebazzar.Presentation.Screens.Main_Page.Components

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageEvent
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPageViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomAppBarMainPage(
    currentScreenId: String,
    onItemSelected:(AppBottomItem)->Unit

) {

    val items= AppBottomItem.Items.list
    val context = LocalContext.current
    Row(
        modifier= Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        items.forEach { item->

            CustomBottomNavigationItem(item = item, isSelected = item.id==currentScreenId,context) {
                onItemSelected(item)
            }

        }

    }

}

@ExperimentalAnimationApi
@Composable
fun CustomBottomNavigationItem(
    item:AppBottomItem,
    isSelected:Boolean,
    context: Context,
    onClick:()->Unit){

    val viewModel: MainPageViewModel =  hiltViewModel()
    val background=if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor=if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ){
        Row(
            modifier=Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(
                imageVector = item.icon,
                contentDescription =null,
                tint = contentColor
            )

            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = item.title,
                    color=contentColor,
                    modifier = Modifier.clickable(onClick = {

                        viewModel.MainPageEventVM(MainPageEvent.onClickAppBarItem(item.id))
                    })
                )
            }

        }
    }


}
