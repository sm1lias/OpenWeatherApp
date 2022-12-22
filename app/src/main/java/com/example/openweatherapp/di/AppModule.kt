package com.example.openweatherapp.di

import com.example.openweatherapp.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofitApi(): WeatherApi{
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/v1")
            .build()
            .create(WeatherApi::class.java)
    }
}