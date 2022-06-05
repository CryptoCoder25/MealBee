package com.example.recipebazzar.Domain.Utils

sealed class CheckListNoteOrderBy(val orderType: OrderType){

    class Title(orderType: OrderType):  CheckListNoteOrderBy(orderType)
    class Date(orderType: OrderType):  CheckListNoteOrderBy(orderType)
    class Color(orderType: OrderType):  CheckListNoteOrderBy(orderType)

    fun copy(orderType: OrderType): CheckListNoteOrderBy {
        return when(this) {
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            is Color -> Color(orderType)
        }
    }
}



