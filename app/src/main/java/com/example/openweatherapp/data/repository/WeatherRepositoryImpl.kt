package com.example.openweatherapp.data.repository

import com.example.openweatherapp.data.remote.WeatherApi
import com.example.openweatherapp.data.remote.dto.WeatherDto
import com.example.openweatherapp.data.remote.dto.toWeather
import com.example.openweatherapp.domain.model.Weather
import com.example.openweatherapp.domain.repository.WeatherRepository
import retrofit2.HttpException
import retrofit2.Response
import com.example.openweatherapp.common.Resource
import java.io.IOException
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherApi: WeatherApi): WeatherRepository {

    override suspend fun getWeather(lat: String, lon:String): Resource<Weather> {
        return try {
            weatherToResource(weatherApi.getWeather(lat, lon))
        } catch (e: IOException) {
            Resource.Error("No internet connection")
        } catch (e: HttpException){
            Resource.Error(e.message())
        }
    }

    private fun weatherToResource(response: Response<WeatherDto>): Resource<Weather> {
        if (response.isSuccessful) {
            response.body()?.let { weatherDto ->
                return Resource.Success(weatherDto.toWeather())
            }
        }
        return Resource.Error(response.message())
    }
}