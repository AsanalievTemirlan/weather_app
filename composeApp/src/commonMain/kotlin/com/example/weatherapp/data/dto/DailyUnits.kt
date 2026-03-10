package com.example.weatherapp.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyUnits(
    @SerialName("temperature_2m_max")
    val temperature2mMax: String? = null,
    @SerialName("temperature_2m_min")
    val temperature2mMin: String? = null,
    @SerialName("time")
    val time: String? = null,
    @SerialName("weathercode")
    val weathercode: String? = null
)