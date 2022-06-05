package com.example.recipebazzar.Presentation.Screens.CheckListNote_Page.Components


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipebazzar.Domain.Utils.CheckListNoteOrderBy
import com.example.recipebazzar.Domain.Utils.OrderType


@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: CheckListNoteOrderBy = CheckListNoteOrderBy.Date(OrderType.Descending),
    onOrderChange: (CheckListNoteOrderBy) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Title",
                selected = noteOrder is CheckListNoteOrderBy.Title,
                onSelect = { onOrderChange(CheckListNoteOrderBy.Title(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = noteOrder is CheckListNoteOrderBy.Date,
                onSelect = { onOrderChange(CheckListNoteOrderBy.Date(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Color",
                selected = noteOrder is CheckListNoteOrderBy.Color,
                onSelect = { onOrderChange(CheckListNoteOrderBy.Color(noteOrder.orderType)) }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = noteOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}