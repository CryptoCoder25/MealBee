package com.example.recipebazzar.Presentation.Screens.CheckListNote_Page

import com.example.recipebazzar.Domain.Models.CheckListNote
import com.example.recipebazzar.Domain.Utils.CheckListNoteOrderBy

sealed class CheckListNoteEvent {
    data class onClikcOrderBy(val noteOrder: CheckListNoteOrderBy) : CheckListNoteEvent()
    data class onClickDeleteNote(val note: CheckListNote) : CheckListNoteEvent()
    object RestoreNote : CheckListNoteEvent()
    object ToggleOrderSection : CheckListNoteEvent()
}
