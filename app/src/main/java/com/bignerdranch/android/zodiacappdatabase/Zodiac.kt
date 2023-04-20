package com.bignerdranch.android.zodiacappdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID
import java.util.Date

@Entity(tableName = "Zodiac")
data class Zodiac(
    @PrimaryKey(autoGenerate = true)
    val id: Integer?,
    val name: String?,
    val description: String?,
    val symbol: String?,
    val month: String?
)
