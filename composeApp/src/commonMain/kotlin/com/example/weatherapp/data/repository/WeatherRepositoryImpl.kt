package com.example.weatherapp.data.repository

import com.example.weatherapp.data.api.WeatherApi
import com.example.weatherapp.data.dto.WeatherDto
import com.example.weatherapp.domain.model.WeatherData
import com.example.weatherapp.domain.repository.WeatherRepository
import util.NetworkError
import util.Result
import util.map

class WeatherRepositoryImpl(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, lon: Double): Result<WeatherData, NetworkError> {
        return api.getWeather(lat, lon).map { it.toWeatherData() }
    }

    private fun WeatherDto?.toWeatherData(): WeatherData {
        return WeatherData(
            temperature = this?.currentWeather?.temperature,
            time = this?.currentWeather?.time,
            windSpeed = this?.currentWeather?.windspeed,
            weatherCode = this?.currentWeather?.weathercode
        )
    }
}
