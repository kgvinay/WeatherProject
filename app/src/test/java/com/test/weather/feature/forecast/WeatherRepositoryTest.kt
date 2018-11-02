package com.test.weather.feature.forecast

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import com.nhaarman.mockito_kotlin.willReturn
import com.test.weather.UnitTest
import com.test.weather.core.exception.Failure
import com.test.weather.core.functional.Either
import com.test.weather.core.platform.NetworkHandler
import com.test.weather.feature.forecast.response.ForecastResponse
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import retrofit2.Call
import retrofit2.Response

class WeatherRepositoryTest : UnitTest() {

    private lateinit var networkRepository: WeatherRepository.Network

    @Mock
    private lateinit var networkHandler: NetworkHandler
    @Mock
    private lateinit var service: WeatherService
    @Mock private lateinit var forecastCall: Call<ForecastResponse>
    @Mock private lateinit var forecastResponse: Response<ForecastResponse>

    @Before
    fun setUp() {
        networkRepository = WeatherRepository.Network(networkHandler, service)
    }

    @Test
    fun `should null by default`() {
        given { networkHandler.isConnected }.willReturn(true)
        given { forecastResponse.body() }.willReturn(null)
        given { forecastResponse.isSuccessful }.willReturn(true)
        given { forecastCall.execute() }.willReturn(forecastResponse)
        given { service.forecastDetails()}.willReturn(forecastCall)

        val movies = networkRepository.forecast()

        movies shouldEqual Either.Right(null)
        verify(service).forecastDetails()
    }

//    @Test fun `should get movie list from service`() {
//        given { networkHandler.isConnected }.willReturn(true)
//        given { forecastResponse.body() }.willReturn(ForecastResponse()))
//        given { forecastResponse.isSuccessful }.willReturn(true)
//        given { forecastCall.execute() }.willReturn(forecastCall)
//        given { service.forecastDetails() }.willReturn(forecastCall)
//
//        val movies = networkRepository.forecast()
//
//        movies shouldEqual Either.Right(ForecastResponse()))
//        verify(service).forecastDetails()
//    }

    @Test fun `weather service should return network failure when no connection`() {
        given { networkHandler.isConnected }.willReturn(false)

        val movies = networkRepository.forecast()

        movies shouldBeInstanceOf Either::class.java
        movies.isLeft shouldEqual true
        movies.either({ failure -> failure shouldBeInstanceOf Failure.NetworkConnection::class.java }, {})
        verifyZeroInteractions(service)
    }

    @Test fun `weather service should return network failure when undefined connection`() {
        given { networkHandler.isConnected }.willReturn(null)

        val movies = networkRepository.forecast()

        movies shouldBeInstanceOf Either::class.java
        movies.isLeft shouldEqual true
        movies.either({ failure -> failure shouldBeInstanceOf Failure.NetworkConnection::class.java }, {})
        verifyZeroInteractions(service)
    }

    @Test fun `weather service should return server error if no successful response`() {
        given { networkHandler.isConnected }.willReturn(true)

        val movies = networkRepository.forecast()

        movies shouldBeInstanceOf Either::class.java
        movies.isLeft shouldEqual true
        movies.either({ failure -> failure shouldBeInstanceOf Failure.ServerError::class.java }, {})
    }

    @Test fun `weather request should catch exceptions`() {
        given { networkHandler.isConnected }.willReturn(true)

        val movies = networkRepository.forecast()

        movies shouldBeInstanceOf Either::class.java
        movies.isLeft shouldEqual true
        movies.either({ failure -> failure shouldBeInstanceOf Failure.ServerError::class.java }, {})
    }


}