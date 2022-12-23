package com.example.openweatherapp.data.remote.dto


import com.example.openweatherapp.domain.model.Weather
import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("elevation")
    val elevation: Double,
    @SerializedName("generationtime_ms")
    val generationTimeMs: Double,
    @SerializedName("hourly")
    val hourly: Hourly,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits,
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
    return Weather(
        latitude = this.latitude,
        longitude = this.longitude,
        weatherPerHourly = this.hourly,
        symbol = this.hourlyUnits.temperature2m
    )
}