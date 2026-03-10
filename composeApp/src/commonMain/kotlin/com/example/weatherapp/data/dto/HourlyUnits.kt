package com.example.weatherapp.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyUnits(
    @SerialName("relativehumidity_2m")
    val relativehumidity2m: String? = null,
    @SerialName("temperature_2m")
    val temperature2m: String? = null,
    @SerialName("time")
    val time: String? = null
)