package com.example.openweatherapp.api

import retrofit2.http.GET

interface WeatherApi {

    @GET()
    suspend fun getWeather()
}