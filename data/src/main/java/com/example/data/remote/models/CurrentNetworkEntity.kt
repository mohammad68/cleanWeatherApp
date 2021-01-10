package com.example.data.remote.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentNetworkEntity(

    @SerializedName("temp")
    @Expose
    val temp: String,

    @SerializedName("weather")
    @Expose
    val weather: List<WeatherDetailNetworkEntity>,

    @SerializedName("pressure")
    @Expose
    val pressure: Int,

    @SerializedName("humidity")
    @Expose
    val humidity: Int,

    @SerializedName("visibility")
    @Expose
    val visibility: Int,

    @SerializedName("wind_speed")
    @Expose
    val windSpeed: Float)