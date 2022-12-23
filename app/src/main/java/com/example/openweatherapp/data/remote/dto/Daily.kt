package com.example.openweatherapp.data.remote.dto


import com.example.openweatherapp.common.Constants
import com.example.openweatherapp.domain.model.WeatherPerDay
import com.google.gson.annotations.SerializedName

data class Daily(
    @SerializedName("temperature_2m_max")
    val temperature2mMax: List<Double>,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: List<Double>,
    @SerializedName("time")
    val time: List<String>,
    @SerializedName("weathercode")
    val weatherCode: List<Int>
)

fun Daily.toWeatherPerDay(): WeatherPerDay {
    return WeatherPerDay(
        maxTemperature = this.temperature2mMax.map { it.toInt() },
        minTemperature = this.temperature2mMin.map { it.toInt() },
        time = this.time,
        status = this.weatherCode.map { Constants.weatherCodes.getOrDefault(it, "") }
    )
}