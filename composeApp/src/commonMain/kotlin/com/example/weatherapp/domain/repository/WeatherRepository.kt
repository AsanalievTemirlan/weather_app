package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.model.WeatherData
import util.NetworkError
import util.Result

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, lon: Double): Result<WeatherData, NetworkError>
}
