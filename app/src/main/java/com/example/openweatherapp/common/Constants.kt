package com.example.openweatherapp.common

object Constants {
    const val BASE_URL = "https://api.open-meteo.com/v1/"

    val weatherCodes = mapOf(
        0 to "Clear sky",
        1 to "Mainly clear",
        2 to "Partly cloudy",
        3 to "Overcast",
        45 to "Fog",
        48 to "Depositing rime fog",
        51 to "Light drizzle",
        53 to "Moderate drizzle",
        55 to "Dense drizzle",
        56 to "Freezing light drizzle",
        57 to "Freezing dense drizzle",
        61 to "Slight rain",
        63 to "Moderate rain",
        65 to "Heavy rain",
        71 to "Slight snow fall",
        73 to "Moderate snow fall",
        75 to "Heavy snow fall",
        77 to "Snow grains",
        80 to "Slight rain showers",
        81 to "Moderate rain showers",
        82 to "Violent rain showers",
        85 to "Slight snow showers",
        86 to "Heavy snow showers",
        95 to "Thunderstorm",
        96 to "Thunderstorm with slight hail",
        99 to "Thunderstorm with heavy hail"
    )
}