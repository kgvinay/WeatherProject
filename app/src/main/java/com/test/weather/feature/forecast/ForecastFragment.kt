package com.test.weather.feature.forecast


import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.test.weather.R
import com.test.weather.R.id.tv_forecast_temp
import com.test.weather.core.exception.Failure
import com.test.weather.core.extension.failure
import com.test.weather.core.extension.observe
import com.test.weather.core.extension.viewModel
import com.test.weather.core.platform.BaseFragment
import com.test.weather.feature.forecast.response.ForecastResponse
import kotlinx.android.synthetic.main.fragment_forecast.*
import javax.inject.Inject
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController



class ForecastFragment : BaseFragment() {

    private lateinit var forecastViewModel: ForecastViewModel
    @Inject
    lateinit var forecastAdapter: ForecastAdapter

    override fun layoutId() = R.layout.fragment_forecast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        forecastViewModel = viewModel(viewModelFactory) {
            observe(forecast, ::updateForecastDetails)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       forecastViewModel.loadForecast()
        initializeView()
    }

    private fun initializeView() {
        rv_forecast_list.layoutManager = LinearLayoutManager(activity,
                LinearLayoutManager.VERTICAL, false);
        val resId = R.anim.layout_animation_fall_down
        val animation = AnimationUtils.loadLayoutAnimation(activity, resId)
        rv_forecast_list.setLayoutAnimation(animation);
        rv_forecast_list.adapter = forecastAdapter


    }

    private fun updateForecastDetails(forecastResponse: ForecastResponse?) {
        tv_forecast_temp.setText(""+forecastResponse?.forecast?.forecastday?.first()?.day?.avgtempC+"c")
        forecastAdapter.collection = forecastResponse?.forecast?.forecastday!!
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
