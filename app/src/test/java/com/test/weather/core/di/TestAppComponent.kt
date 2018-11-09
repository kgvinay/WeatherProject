package com.test.weather.core.di

import com.squareup.okhttp.mockwebserver.MockWebServer
import com.test.weather.WeatherApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    MockApplicationModule::class,
    ActivityBindingModule::class
])
interface TestAppComponent : ApplicationComponent {

    fun getMockWebServer(): MockWebServer

    @Component.Builder
    interface Builder{

        fun build(): TestAppComponent

        @BindsInstance
        fun application(application: WeatherApplication): Builder


    }
}