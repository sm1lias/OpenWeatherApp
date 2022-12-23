package com.example.openweatherapp.data.remote.dto


import com.example.openweatherapp.common.Utils
import com.example.openweatherapp.domain.model.Weather
import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("daily")
    val daily: Daily,
    @SerializedName("daily_units")
    val dailyUnits: DailyUnits,
    @SerializedName("hourly")
    val hourly: Hourly,
    @SerializedName("elevation")
    val elevation: Double,
    @SerializedName("generationtime_ms")
    val generationTimeMs: Double,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int
)

fun WeatherDto.toWeather(): Weather{
    val hourlyMap = this.hourly.toWeatherHourlyMap()
    return Weather(
        latitude = this.latitude,
        longitude = this.longitude,
        weatherPerDay = this.daily.toWeatherPerDay(),
        temperatureHourly =  hourlyMap,
        temperature = hourlyMap[Utils.getCurrentTimeInISO8601()]?.toInt()?: 0
    )
}