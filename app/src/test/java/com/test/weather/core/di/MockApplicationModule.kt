package com.test.weather.core.di

import com.google.gson.Gson
import com.squareup.okhttp.mockwebserver.MockWebServer
import com.test.weather.feature.forecast.WeatherAPI
import com.test.weather.feature.forecast.WeatherRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class MockApplicationModule {

    @Provides
    @Singleton
    fun provideMockServer (): MockWebServer {
        var mockWebServer:MockWebServer? = null

        val thread = Thread(Runnable {
            mockWebServer = MockWebServer()
            mockWebServer?.start()
        })
        thread.start()
        thread.join()
        return mockWebServer ?: throw NullPointerException()
    }

//    @Provides
//    @Singleton
//    @Named("baseUrl")
//    fun provideBaseUrl (mockWebServer:MockWebServer): String {
//        var url = ""
//        val t = Thread(Runnable {
//            url = mockWebServer.url("/").toString()
//        })
//        t.start()
//        t.join()
//        return url
//    }

    @Provides
    @Singleton
    internal fun provideRestApi(gson: Gson): WeatherAPI {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("/")
                .build()
                .create(WeatherAPI::class.java)
    }

    @Provides @Singleton fun provideMoviesRepository(dataSource: WeatherRepository.Network): WeatherRepository = dataSource


}