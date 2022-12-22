package com.example.openweatherapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.api.WeatherApi
import com.example.openweatherapp.data.Weather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstFragmentViewModel @Inject constructor(
    private val api: WeatherApi
): ViewModel() {

    fun getWeather(){
        viewModelScope.launch {
             val data: Weather = api.getWeather("37.98", "23.73")
            Log.d("TAG", "getWeather: $data")
        }
    }

}