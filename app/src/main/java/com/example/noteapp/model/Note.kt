package com.example.noteapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes_tbl")
data class Note(
    @PrimaryKey
    val id: UUID= UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    val title : String,

    @ColumnInfo(name = "note_description")
    val description: String,



    @ColumnInfo(name = "note_entry_date")
    val entryDate: Date = Date.from(Instant.now())
//    val entryDate: Date = if (isInEditMode) {
//        Date.from(Instant.parse("2022-01-01T00:00:00Z"))
//    } else {
//        Date.from(Instant.now())
//    }
//    val entryDate: Date = Date.from(Instant.now())
//    val entryDate: Date by lazy { Date.from(Instant.now()) }

)
