package com.bignerdranch.android.zodiacappdatabase.database

import androidx.room.Dao
import androidx.room.Query
import com.bignerdranch.android.zodiacappdatabase.Zodiac
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface ZodiacDao {
    @Query("SELECT * FROM Zodiac")
    fun getZodiacs(): Flow<List<Zodiac>>

    @Query("SELECT * FROM Zodiac WHERE id=(:id)")
    suspend fun getZodiac(id: Int): Zodiac
}
