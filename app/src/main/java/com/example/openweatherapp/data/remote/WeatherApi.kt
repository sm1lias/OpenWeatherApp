package com.example.openweatherapp.data.remote

import com.example.openweatherapp.data.remote.dto.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude") lat: String,
        @Query("longitude") lon: String,
        @Query("daily", encoded = true) daily: String = "weathercode,temperature_2m_max,temperature_2m_min",
        @Query("hourly", encoded = true) hourly: String = "temperature_2m",
        @Query("timezone") timezone: String = "Africa/Cairo"

    ): Response<WeatherDto>
}