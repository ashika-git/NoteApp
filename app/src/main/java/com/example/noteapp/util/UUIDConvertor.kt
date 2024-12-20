package com.example.noteapp.util

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.UUID

class UUIDConvertor {
    @TypeConverter
    fun fromUUID(uuid : UUID): String? {
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(string: String?) : UUID?{
        return UUID.fromString(string)
    }
}