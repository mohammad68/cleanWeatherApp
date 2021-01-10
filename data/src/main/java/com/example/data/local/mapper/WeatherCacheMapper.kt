package com.example.data.local.mapper

import com.example.data.local.model.WeatherCacheEntity
import com.example.domain.util.EntityMapper
import com.example.domain.model.Weather
import javax.inject.Inject

class WeatherCacheMapper
@Inject
constructor (): EntityMapper<WeatherCacheEntity,Weather>{

    override fun mapFromEntity(entity: WeatherCacheEntity): Weather = Weather(
           temp = entity.temp,
           icon = entity.icon,
           description = entity.description,
           windSpeed = entity.windSpeed,
           visibility = entity.visibility,
           humidity = entity.humidity
       )

    override fun mapToEntity(domainModel: Weather): WeatherCacheEntity =
       throw NotImplementedError()
}