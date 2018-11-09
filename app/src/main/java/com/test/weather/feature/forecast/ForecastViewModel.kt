package com.test.weather.feature.forecast

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.test.weather.core.interactor.UseCase
import com.test.weather.core.platform.BaseViewModel
import com.test.weather.feature.forecast.response.Forecast
import com.test.weather.feature.forecast.response.ForecastResponse
import javax.inject.Inject

class ForecastViewModel
@Inject constructor(private val getForecast: GetForecast) : BaseViewModel() {

    var forecast: MutableLiveData<Forecast> = MutableLiveData()


    fun loadForecast() = getForecast(UseCase.None())
    { it.either(::handleFailure, ::handleForecastList) }

    private fun handleForecastList(forecastResponse: Forecast) {
        forecast.value = forecastResponse
    }

}