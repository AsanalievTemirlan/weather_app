package com.example.weatherapp.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hourly(
    @SerialName("relativehumidity_2m")
    val relativehumidity2m: List<Int?>? = null,
    @SerialName("temperature_2m")
    val temperature2m: List<Double?>? = null,
    @SerialName("time")
    val time: List<String?>? = null
)