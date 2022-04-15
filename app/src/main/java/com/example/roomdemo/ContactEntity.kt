package com.example.roomdemo

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "contact")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val mobile: String,
    val date: Date
)
