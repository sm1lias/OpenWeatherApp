package com.example.openweatherapp.data


import com.google.gson.annotations.SerializedName

data class Hourly(
    @SerializedName("temperature_2m")
    val temperature2m: List<Double>,
    @SerializedName("time")
    val time: List<String>
)