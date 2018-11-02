package com.test.weather.feature.forecast

import com.test.weather.feature.forecast.response.ForecastResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


    interface WeatherAPI {
        companion object {

            private const val PARAM_KEY  = "c626c1021a5b4206b6d143758180111"
            private const val PARAM_LOC  = "Bangalore"
            private const val PARAM_DAYS = "4"
            private const val FORECAST_DETAILS = "forecast.json?key=$PARAM_KEY&q=$PARAM_LOC&days=$PARAM_DAYS"
        }

        @GET(FORECAST_DETAILS)
        fun forecastDetails(): Call<ForecastResponse>
    }