package com.example.weatherapp.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    @SerialName("current_weather")
    val currentWeather: CurrentWeather? = null,
    @SerialName("current_weather_units")
    val currentWeatherUnits: CurrentWeatherUnits? = null,
    @SerialName("daily")
    val daily: Daily? = null,
    @SerialName("daily_units")
    val dailyUnits: DailyUnits? = null,
    @SerialName("elevation")
    val elevation: Double? = null,
    @SerialName("generationtime_ms")
    val generationtimeMs: Double? = null,
    @SerialName("hourly")
    val hourly: Hourly? = null,
    @SerialName("hourly_units")
    val hourlyUnits: HourlyUnits? = null,
    @SerialName("latitude")
    val latitude: Double? = null,
    @SerialName("longitude")
    val longitude: Double? = null,
    @SerialName("timezone")
    val timezone: String? = null,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String? = null,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int? = null
)