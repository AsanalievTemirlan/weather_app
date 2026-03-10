package com.example.weatherapp.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(
    @SerialName("is_day")
    val isDay: Int? = null,
    @SerialName("temperature")
    val temperature: Double? = null,
    @SerialName("time")
    val time: String? = null,
    @SerialName("weathercode")
    val weathercode: Int? = null,
    @SerialName("winddirection")
    val winddirection: Double? = null,
    @SerialName("windspeed")
    val windspeed: Double? = null
)