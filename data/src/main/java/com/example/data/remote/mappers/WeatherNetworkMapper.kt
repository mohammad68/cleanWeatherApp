package com.example.data.remote.mappers

import com.example.data.remote.models.WeatherNetworkEntity
import com.example.domain.util.EntityMapper
import com.example.domain.model.Weather
import javax.inject.Inject

class WeatherNetworkMapper
@Inject
constructor(): EntityMapper<WeatherNetworkEntity, Weather> {

    override fun mapFromEntity(entity: WeatherNetworkEntity): Weather =
        Weather(
            temp = entity.current.temp,
            icon = entity.current.weather.first().icon,
            description = entity.current.weather.first().description,
            windSpeed = entity.current.windSpeed,
            visibility = entity.current.visibility,
            humidity = entity.current.humidity
        )

    override fun mapToEntity(domainModel: Weather): WeatherNetworkEntity {
        throw NotImplementedError()
    }
}