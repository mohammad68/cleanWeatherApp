package com.example.data.remote.models

import com.example.data.remote.models.CurrentNetworkEntity
import com.example.data.remote.models.DailyNetworkEntity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherNetworkEntity(
    @SerializedName("current")
    @Expose
    val current: CurrentNetworkEntity,

    @SerializedName("current")
    @Expose
    val daily: List<DailyNetworkEntity>
)