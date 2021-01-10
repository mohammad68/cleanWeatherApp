package com.example.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.local.LocalConst

@Entity(tableName = LocalConst.TBl_WEATHER)
class WeatherCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name= "id")
    val id: Int,

    @ColumnInfo(name= "temp")
    val temp: String,

    @ColumnInfo(name= "icon")
    val icon: String,

    @ColumnInfo(name= "description")
    val description: String,

    @ColumnInfo(name= "windSpeed")
    val windSpeed: Float,

    @ColumnInfo(name= "visibility")
    val visibility: Int,

    @ColumnInfo(name= "humidity")
    val humidity: Int
)