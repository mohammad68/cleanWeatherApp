package com.example.data.local.room

import androidx.room.*
import com.example.data.local.model.WeatherCacheEntity

@Dao
interface WeatherDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherEntity: WeatherCacheEntity): Long

    @Query("SELECT * FROM Weather")
    suspend fun getWeather(): WeatherCacheEntity

    @Delete
    suspend fun deleteWeather(weatherEntity: WeatherCacheEntity)
}