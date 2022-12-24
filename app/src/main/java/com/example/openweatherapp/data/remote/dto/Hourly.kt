package com.example.openweatherapp.data.remote.dto


import com.example.openweatherapp.common.Utils
import com.example.openweatherapp.domain.model.WeatherType
import com.google.gson.annotations.SerializedName

data class Hourly(
    @SerializedName("temperature_2m")
    val temperature2m: List<Double>,
    @SerializedName("time")
    val time: List<String>,
    @SerializedName("weathercode")
    val weatherCode: List<Int>
)

fun Hourly.toWeatherHourlyMap(): List<Triple<String, Double, WeatherType>> {
    val listWeatherType = weatherCode.map { WeatherType.fromCode(it)}
    return Utils.tripleListsToTripleIfSameSize(
        this.time,
        this.temperature2m,
        listWeatherType)
} // we want WeatherType object instead of weatherCode