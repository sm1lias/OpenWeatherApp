package com.example.openweatherapp.domain.model

import com.example.openweatherapp.data.remote.dto.Hourly

data class Weather(
    val latitude: Double,
    val longitude: Double,
    val weatherPerHourly: Hourly,
    val symbol: String
)
