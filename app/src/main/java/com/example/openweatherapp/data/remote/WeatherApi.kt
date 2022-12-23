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
        @Query("hourly") hourly: String = "temperature_2m",

    ): Response<WeatherDto>
}