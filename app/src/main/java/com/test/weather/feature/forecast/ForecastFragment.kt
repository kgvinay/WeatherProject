package com.test.weather.feature.forecast


import android.os.Bundle
import android.support.annotation.StringRes
import com.test.weather.R
import com.test.weather.core.exception.Failure
import com.test.weather.core.extension.failure
import com.test.weather.core.extension.observe
import com.test.weather.core.extension.viewModel
import com.test.weather.core.platform.BaseFragment
import com.test.weather.feature.forecast.response.ForecastResponse

class ForecastFragment : BaseFragment() {

    private lateinit var forecastViewModel: ForecastViewModel

    override fun layoutId() = R.layout.fragment_forecast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        forecastViewModel = viewModel(viewModelFactory) {
            observe(forecast, ::updateForecastDetails)
            failure(failure, ::handleFailure)
        }
    }

    private fun updateForecastDetails(forecastResponse: ForecastResponse?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
            is WeatherFailure.ListNotAvailable -> renderFailure(R.string.failure_weather_list_unavailable)
        }
    }

    private fun renderFailure(@StringRes message: Int) {
//        movieList.invisible()
//        emptyView.visible()
//        hideProgress()
//        notifyWithAction(message, R.string.action_refresh, ::loadMoviesList)
    }

}
