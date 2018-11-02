package com.test.weather.feature.forecast

import android.arch.lifecycle.MutableLiveData
import com.test.weather.core.interactor.UseCase
import com.test.weather.core.platform.BaseViewModel
import com.test.weather.feature.forecast.response.ForecastResponse
import javax.inject.Inject

class ForecastViewModel
@Inject constructor(private val getForecast: GetForecast) : BaseViewModel() {

    var forecast: MutableLiveData<ForecastResponse> = MutableLiveData()

    fun loadForecast() = getForecast(UseCase.None()) { it.either(::handleFailure, ::handleForecastList) }

    private fun handleForecastList(forecastResponse: ForecastResponse) {
        forecast.value = forecastResponse
    }

}