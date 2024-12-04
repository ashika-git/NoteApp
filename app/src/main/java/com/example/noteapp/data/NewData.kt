package com.example.noteapp.data

import com.example.noteapp.model.Note

class NewDataSource {

    fun loadNotes(): List<Note>{
        return listOf(
            Note(title =" A good Day", description = "we want ............."),
            Note(title =" A good Day", description = "we want ............."),
            Note(title =" A good Day", description = "we want ............."),
            Note(title =" A good Day", description = "we want ............."),
            Note(title =" A good Day", description = "we want ............."),
            Note(title =" A good Day", description = "we want ............."),
            Note(title =" A good Day", description = "we want ............."),
            Note(title =" A good Day", description = "we want ............."),
            Note(title =" A good Day", description = "we want ............."),
            Note(title =" A good Day", description = "we want ............."),
            Note(title =" A good Day", description = "we want ............."),
            Note(title =" A good Day", description = "we want .............")
        )
    }
}