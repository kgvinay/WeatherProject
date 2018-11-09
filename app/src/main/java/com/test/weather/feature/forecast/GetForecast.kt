package com.test.weather.feature.forecast

import com.test.weather.core.interactor.UseCase
import com.test.weather.feature.forecast.response.Forecast
import com.test.weather.feature.forecast.response.ForecastResponse
import javax.inject.Inject

class GetForecast @Inject constructor(private val weatherRepository: WeatherRepository) :
        UseCase<Forecast, UseCase.None>() {

    override suspend fun run(params: None) = weatherRepository.forecast()
}