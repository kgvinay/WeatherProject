package com.test.weather

import com.test.weather.core.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class WeatherApplication :   DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerApplicationComponent
                .builder()
                .application(this)
                .build()

    }
}