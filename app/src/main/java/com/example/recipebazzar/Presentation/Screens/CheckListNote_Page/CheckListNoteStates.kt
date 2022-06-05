package com.example.recipebazzar.Presentation.Screens.CheckListNote_Page

import com.example.recipebazzar.Domain.Models.CheckListNote
import com.example.recipebazzar.Domain.Utils.CheckListNoteOrderBy
import com.example.recipebazzar.Domain.Utils.OrderType

data class CheckListNoteStates(
    val notes: List<CheckListNote> = emptyList(),
    val noteOrder: CheckListNoteOrderBy = CheckListNoteOrderBy.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
