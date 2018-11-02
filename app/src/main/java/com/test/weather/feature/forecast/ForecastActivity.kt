package com.test.weather.feature.forecast

import android.content.Context
import android.content.Intent
import com.test.weather.core.platform.BaseActivity

class ForecastActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, ForecastActivity::class.java)
    }

    override fun fragment() = ForecastFragment()
}
