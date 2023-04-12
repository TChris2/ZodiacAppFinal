package com.bignerdranch.android.zodiacappdatabase

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.zodiacappdatabase.database.ZodiacDatabase
import kotlinx.coroutines.flow.Flow
import java.util.UUID

private const val DATABASE_NAME = "zodiac-database"

class ZodiacRepository private constructor(context: Context) {

    private val database: ZodiacDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            ZodiacDatabase::class.java,
            DATABASE_NAME
        )
        .createFromAsset(DATABASE_NAME)
        .build()

    fun getCrimes(): Flow<List<Zodiac>> = database.crimeDao().getCrimes()

    suspend fun getCrime(id: UUID): Zodiac = database.crimeDao().getCrime(id)

    companion object {
        private var INSTANCE: ZodiacRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = ZodiacRepository(context)
            }
        }

        fun get(): ZodiacRepository {
            return INSTANCE
                ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}
