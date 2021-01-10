package com.example.domain.repository

import com.example.domain.model.Weather
import com.example.domain.util.DataState
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeather(): Flow<DataState<Weather>>
}