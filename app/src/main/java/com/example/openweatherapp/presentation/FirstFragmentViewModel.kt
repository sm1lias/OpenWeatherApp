package com.example.openweatherapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.domain.model.Weather
import com.example.openweatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import com.example.openweatherapp.common.Resource
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FirstFragmentViewModel @Inject constructor(
    private val repository: WeatherRepository
): ViewModel() {

    val data: MutableStateFlow<Resource<Weather>?> = MutableStateFlow(null)

    fun getWeather(){
        viewModelScope.launch(Dispatchers.IO) {
            data.value = Resource.Loading()
            data.value = repository.getWeather("23.73", "37.98")
            if (data.value?.data.toString().isNotEmpty())
                Timber.i( "loadWeather: ${data.value!!.data.toString()}")
        }
    }

}