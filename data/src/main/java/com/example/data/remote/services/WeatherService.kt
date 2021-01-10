package com.example.data.remote.services

import com.example.data.remote.NetworkEndpoints
import com.example.data.remote.models.WeatherNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(NetworkEndpoints.ONE_CALL)
    suspend fun getWeather(
        @Query("lat") lat: String
       ,@Query("lon") lon: String
       ,@Query("appid") appId: String
       ,@Query("units") units: String): WeatherNetworkEntity
}