package com.example.data.remote.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherDetailNetworkEntity(

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("max")
    @Expose
    val max: Float,

    @SerializedName("min")
    @Expose
    val min: Float,

    @SerializedName("description")
    @Expose
    val description: String,

    @SerializedName("icon")
    @Expose
    val icon: String
)