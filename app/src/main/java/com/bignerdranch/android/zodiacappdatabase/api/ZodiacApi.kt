package com.bignerdranch.android.zodiacappdatabase.api

import retrofit2.http.GET

interface ZodiacApi {
    @GET("/horoscopes/")
    suspend fun fetchContents(): List<ZodiacItem>
}