package com.example.openweatherapp.domain.model

data class WeatherPerDay(
    val maxTemperature: List<Int>,
    val minTemperature: List<Int>,
    val time: List<String>,
    val status: List<WeatherType>
)
