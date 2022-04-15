package com.example.roomdemo

import androidx.room.TypeConverter
import java.util.*


class Convertor {
    @TypeConverter
    fun fromDateToLong(value: Date): Long {
        return value.time
    }
    @TypeConverter
    fun fromLongToDate(long:Long):Date {
        return Date(long)
    }}