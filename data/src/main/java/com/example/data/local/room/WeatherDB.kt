package com.example.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.model.WeatherCacheEntity

@Database(entities = [WeatherCacheEntity::class],version = 1)
abstract class WeatherDB: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}