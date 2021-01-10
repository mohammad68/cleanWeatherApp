package com.example.data.remote.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DailyNetworkEntity(

    @SerializedName("temp")
    @Expose
    val temp: TempNetworkEntity,

    @SerializedName("weather")
    @Expose
    val weather: List<WeatherDetailNetworkEntity>
)