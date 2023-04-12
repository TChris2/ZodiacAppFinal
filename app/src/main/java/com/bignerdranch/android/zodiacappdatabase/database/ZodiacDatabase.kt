package com.bignerdranch.android.zodiacappdatabase.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bignerdranch.android.zodiacappdatabase.Zodiac

@Database(entities = [Zodiac::class], version = 1)
abstract class ZodiacDatabase : RoomDatabase() {
    abstract fun zodiacDao(): ZodiacDao
}
