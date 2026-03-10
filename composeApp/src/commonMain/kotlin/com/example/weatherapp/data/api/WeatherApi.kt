package com.example.weatherapp.data.api

import com.example.weatherapp.data.dto.WeatherDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import util.NetworkError
import util.Result

const val BASE_URL = "https://api.open-meteo.com/v1/forecast"

class WeatherApi(
    private val client: HttpClient
) {
    suspend fun getWeather(lat: Double, lon: Double): Result<WeatherDto, NetworkError> {
        val response = try {
            client.get(BASE_URL) {
                parameter("latitude", lat)
                parameter("longitude", lon)
                parameter("current_weather", true)
                parameter("hourly", "temperature_2m,relativehumidity_2m")
                parameter("daily", "weathercode,temperature_2m_max,temperature_2m_min")
                parameter("timezone", "auto")
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        } catch (e: Exception) {
            return Result.Error(NetworkError.UNKNOWN)
        }

        return when (response.status.value) {
            in 200..299 -> {
                try {
                    val weatherDto = response.body<WeatherDto>()
                    Result.Success(weatherDto)
                } catch (e: Exception) {
                    Result.Error(NetworkError.SERIALIZATION)
                }
            }
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}
