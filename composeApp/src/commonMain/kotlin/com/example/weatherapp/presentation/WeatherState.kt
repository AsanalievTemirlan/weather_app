package com.example.weatherapp.presentation

import com.example.weatherapp.domain.model.WeatherData
import util.NetworkError

data class WeatherState(
    val isLoading: Boolean = false,
    val weatherData: WeatherData? = null,
    val error: NetworkError? = null
)
