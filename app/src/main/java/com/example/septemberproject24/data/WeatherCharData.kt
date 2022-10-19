package com.example.septemberproject24.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.septemberproject24.R
import com.example.septemberproject24.utils.formatDecimals

data class WeatherCharData(val title: String, val icon: Painter, val value : String)

val defaultCity by mutableStateOf("Hyderabad")
