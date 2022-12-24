package com.example.openweatherapp.domain.model

data class WeatherHourly(
    val temperature: List<Double>,
    val time: List<String>,
    val weatherType: List<WeatherType>
)
