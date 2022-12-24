package com.example.openweatherapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapp.databinding.HourlyWeatherItemBinding
import com.example.openweatherapp.domain.model.WeatherType

class HourlyWeatherAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private val hourlyWeatherListTriple = ArrayList<Triple<String, Double, WeatherType>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : HourlyWeatherItemBinding = HourlyWeatherItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(hourlyWeatherListTriple[position])
    }

    override fun getItemCount() = hourlyWeatherListTriple.size

    fun setList(list: List<Triple<String, Double, WeatherType>>){
        hourlyWeatherListTriple.clear()
        hourlyWeatherListTriple.addAll(list)
    }
}

class MyViewHolder(private val binding: HourlyWeatherItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(hourlyTriple: Triple<String, Double, WeatherType>) {
        binding.apply {
            txtTemp.text = "${hourlyTriple.second} °C"
            txtTime.text = hourlyTriple.first
            imgStatus.setImageResource(hourlyTriple.third.iconRes)
        }
    }

}