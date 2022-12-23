package com.example.openweatherapp.data.remote.dto


import com.example.openweatherapp.common.Utils
import com.google.gson.annotations.SerializedName

data class Hourly(
    @SerializedName("temperature_2m")
    val temperature2m: List<Double>,
    @SerializedName("time")
    val time: List<String>
)

fun Hourly.toWeatherHourlyMap() = Utils.doubleListsToMapIfSameSize(this.time, this.temperature2m)