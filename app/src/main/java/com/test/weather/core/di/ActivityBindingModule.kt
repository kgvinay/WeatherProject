package com.test.weather.core.di

import com.test.weather.core.navigation.RouteActivity
import com.test.weather.core.platform.BaseFragment
import com.test.weather.feature.forecast.ForecastActivity
import com.test.weather.feature.forecast.ForecastFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBindingModule{

    @ContributesAndroidInjector(modules = [ApplicationModule::class])
    abstract fun bindRouteActivity() : RouteActivity

    @ContributesAndroidInjector(modules = [ApplicationModule::class])
    abstract fun bindForecastActivity() : ForecastActivity

    @ContributesAndroidInjector(modules = [ApplicationModule::class])
    abstract fun bindForecastFragment() : ForecastFragment

    @ContributesAndroidInjector(modules = [ApplicationModule::class])
    abstract fun bindBaseFragment() : BaseFragment
}