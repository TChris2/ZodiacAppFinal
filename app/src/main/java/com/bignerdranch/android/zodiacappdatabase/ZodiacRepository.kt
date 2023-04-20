package com.bignerdranch.android.zodiacappdatabase

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.zodiacappdatabase.database.ZodiacDatabase
import kotlinx.coroutines.flow.Flow

private const val DATABASE_NAME = "zodiac.db"

class ZodiacRepository private constructor(context: Context) {

    private val database: ZodiacDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            ZodiacDatabase::class.java,
            DATABASE_NAME
        )
        .createFromAsset(DATABASE_NAME)
        .build()

    fun getZodiacs(): Flow<List<Zodiac>> = database.zodiacDao().getZodiacs()

    suspend fun getZodiac(id: Int): Zodiac = database.zodiacDao().getZodiac(id)

    companion object {
        private var INSTANCE: ZodiacRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = ZodiacRepository(context)
            }
        }

        fun get(): ZodiacRepository {
            return INSTANCE
                ?: throw IllegalStateException("ZodiacRepository must be initialized")
        }
    }
}