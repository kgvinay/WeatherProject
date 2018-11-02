package com.test.weather.feature.forecast

import android.util.Log
import com.test.weather.core.exception.Failure
import com.test.weather.core.functional.Either
import com.test.weather.core.platform.NetworkHandler
import com.test.weather.feature.forecast.response.ForecastResponse
import retrofit2.Call
import javax.inject.Inject

interface WeatherRepository{

    fun forecast(): Either<Failure, ForecastResponse>


    class Network
    @Inject internal constructor(private val networkHandler: NetworkHandler,
                                 private val service: WeatherService) : WeatherRepository {

        override fun forecast(): Either<Failure, ForecastResponse> {
            return when (networkHandler.isConnected) {
                true -> request(service.forecastDetails(), { it }, ForecastResponse.empty()) as Either<Failure, ForecastResponse>
                false, null -> Either.Left(Failure.NetworkConnection())
            }
        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError())
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError())
            }
        }

    }


    }