package com.test.weather.core.navigation

import android.content.Context
import com.test.weather.feature.forecast.ForecastActivity
import javax.inject.Singleton

@Singleton
class Navigator {

    fun showMain(context: Context) = context.startActivity(ForecastActivity.callingIntent(context))

}