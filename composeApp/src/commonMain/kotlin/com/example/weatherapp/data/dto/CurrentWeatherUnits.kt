package com.example.weatherapp.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherUnits(
    @SerialName("is_day")
    val isDay: String? = null,
    @SerialName("temperature")
    val temperature: String? = null,
    @SerialName("time")
    val time: String? = null,
    @SerialName("weathercode")
    val weathercode: String? = null,
    @SerialName("winddirection")
    val winddirection: String? = null,
    @SerialName("windspeed")
    val windspeed: String? = null
)