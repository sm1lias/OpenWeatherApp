package com.example.openweatherapp.api

import com.example.openweatherapp.data.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude") lat: String,
        @Query("longitude") lon: String,
        @Query("hourly") hourly: String = "temperature_2m",

    ): Weather
}