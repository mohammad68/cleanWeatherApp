package com.example.weather

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WeatherApplication: Application(){
    override fun onCreate() {
        super.onCreate()
    }
}
