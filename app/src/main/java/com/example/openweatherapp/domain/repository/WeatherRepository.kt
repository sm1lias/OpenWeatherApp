package com.example.openweatherapp.domain.repository

import com.example.openweatherapp.domain.model.Weather
import com.example.openweatherapp.common.Resource

interface WeatherRepository {
    suspend fun getWeather(lat: String, lon:String): Resource<Weather>
}