package com.example.domain.usecase

import com.example.domain.model.Weather
import com.example.domain.repository.WeatherRepository
import com.example.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class getWeatherUsecase @Inject constructor(private val repo: WeatherRepository) {
    suspend operator fun invoke(): Flow<DataState<Weather>> = repo.getWeather()
}