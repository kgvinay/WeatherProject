package com.test.weather.feature.forecast

import com.test.weather.feature.forecast.response.ForecastResponse
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherService
@Inject constructor(weatherAPI: WeatherAPI) : WeatherAPI {

    private val weatherAPI = weatherAPI;

    override fun forecastDetails() = this.weatherAPI.forecastDetails()


}