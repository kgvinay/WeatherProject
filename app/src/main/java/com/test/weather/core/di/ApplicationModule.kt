package com.test.weather.core.di

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.weather.WeatherApplication
import com.test.weather.core.functional.ViewModelModule
import com.test.weather.feature.forecast.WeatherAPI
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.HashSet
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class ApplicationModule {

    internal var mBaseUrl = "http://api.apixu.com/v1/"

    @Provides
    @Singleton
    fun provideHttpCache(application: WeatherApplication) : Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideGson() : Gson = GsonBuilder().create()

    inner class LoggingInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()

            val t1 = System.nanoTime()
            Log.d("LOGGY", "intercept: " + String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()))

            val response = chain.proceed(request)

            val t2 = System.nanoTime()
            Log.d("LOGGY", "intercept: " + String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6, response.headers()))

            return response
        }
    }


    @Provides
    @Singleton
    fun provideOkhttpClient(cache: Cache): OkHttpClient {

        val client = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(logging);
        client.addNetworkInterceptor(LoggingInterceptor())
        client.addInterceptor { chain ->
            var request = chain.request()

                request = request.newBuilder()
                        .header("Accept", "application/json;")
                        .method(request.method(), request.body())
                        .build()

            chain.proceed(request)
        }
        client.cache(cache)
        client.connectTimeout(5, TimeUnit.MINUTES)
        client.readTimeout(5, TimeUnit.MINUTES)
        return client.build()
    }

    @Provides
    @Singleton
    internal fun provideRestApi(gson: Gson, okHttpClient: OkHttpClient): WeatherAPI {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build()
                .create(WeatherAPI::class.java)
    }

}