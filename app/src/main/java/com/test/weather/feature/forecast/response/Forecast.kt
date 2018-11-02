package com.test.weather.feature.forecast.response

import com.google.gson.annotations.SerializedName

data class Forecast(@SerializedName("forecastday")
                    val forecastday: List<ForecastdayItem>?)