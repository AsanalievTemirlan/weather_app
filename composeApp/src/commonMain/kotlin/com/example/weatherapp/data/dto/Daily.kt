package com.example.weatherapp.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    @SerialName("temperature_2m_max")
    val temperature2mMax: List<Double?>? = null,
    @SerialName("temperature_2m_min")
    val temperature2mMin: List<Double?>? = null,
    @SerialName("time")
    val time: List<String?>? = null,
    @SerialName("weathercode")
    val weathercode: List<Int?>? = null
)