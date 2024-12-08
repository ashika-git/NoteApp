package com.example.noteapp.util

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date: Date) : Long {
        return date.time
    }

    @TypeConverter
    fun dateFromTimeStamp(timestamp : Long) : Date {
        return Date(timestamp)
    }
}