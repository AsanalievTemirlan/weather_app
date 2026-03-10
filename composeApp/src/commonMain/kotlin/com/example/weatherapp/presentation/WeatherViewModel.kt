package com.example.weatherapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import util.onError
import util.onSuccess

class WeatherViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    init {
        loadWeather()
    }

    fun loadWeather() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            repository.getWeatherData(42.8746, 74.5698)
                .onSuccess { data ->
                    _state.update { it.copy(
                        weatherData = data,
                        isLoading = false
                    ) }
                }
                .onError { error ->
                    _state.update { it.copy(
                        error = error,
                        isLoading = false
                    ) }
                }
        }
    }
}
