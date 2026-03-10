package com.example.weatherapp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.weatherapp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}
