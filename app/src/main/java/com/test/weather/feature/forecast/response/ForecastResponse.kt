package com.test.weather.feature.forecast.response

import com.google.gson.annotations.SerializedName

data class ForecastResponse(@SerializedName("current")
                            val current: Current,
                            @SerializedName("location")
                            val location: Location,
                            @SerializedName("forecast")
                            val forecast: Forecast)