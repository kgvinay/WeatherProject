package com.test.weather.core.di

import com.test.weather.WeatherApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    ActivityBindingModule::class
])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder{

        fun build(): ApplicationComponent

        @BindsInstance
        fun application(application: WeatherApplication): Builder
        

    }

}