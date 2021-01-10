package com.example.data.remote.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TempNetworkEntity {

    @SerializedName("min")
    @Expose
    val min: Float = 0f

    @SerializedName("min")
    @Expose
    val max: Float = 0f
}