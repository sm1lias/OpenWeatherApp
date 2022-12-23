package com.example.openweatherapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.common.Resource
import com.example.openweatherapp.domain.model.Coordinates
import com.example.openweatherapp.domain.model.Weather
import com.example.openweatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DailyWeatherFragmentViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _data: MutableLiveData<Resource<Weather>> = MutableLiveData()
    val data: LiveData<Resource<Weather>> = _data

    fun getWeather(coordinates: Coordinates) {
        viewModelScope.launch {
            _data.value = Resource.Loading()
            val weather = getWeatherFromRepository(coordinates)
            _data.value = weather
            if (_data.value?.data.toString().isNotEmpty())
                Timber.i("Weather object: ${_data.value!!.data.toString()}")
        }
    }

    private suspend fun getWeatherFromRepository(coordinates: Coordinates): Resource<Weather> {
        return withContext(Dispatchers.IO) {
            repository.getWeather(coordinates.lat.toString(), coordinates.lon.toString())
        }
    }

}