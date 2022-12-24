package com.example.openweatherapp.domain.model

data class Weather(
    val latitude: Double,
    val longitude: Double,
    val weatherPerDay: WeatherPerDay,
    val symbol: String = "°C",
    val temperatureHourly: List<Triple<String, Double, WeatherType>>,
    val temperature: Int
)
