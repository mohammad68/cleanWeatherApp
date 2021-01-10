package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.LocalConst
import com.example.data.local.room.WeatherDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Provides
    fun provideWeatherDB(@ApplicationContext context: Context): WeatherDB  =
        Room.databaseBuilder(
            context,
            WeatherDB::class.java,
            LocalConst.DB_WEATHER_APP)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideWeatherDao(weatherDB: WeatherDB) = weatherDB.weatherDao()

}