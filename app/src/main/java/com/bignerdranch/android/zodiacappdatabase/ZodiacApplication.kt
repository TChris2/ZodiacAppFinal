package com.bignerdranch.android.zodiacappdatabase

import android.app.Application

class ZodiacApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ZodiacRepository.initialize(this)
    }
}
