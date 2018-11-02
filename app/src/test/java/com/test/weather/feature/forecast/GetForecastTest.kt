package com.test.weather.feature.forecast

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.test.weather.UnitTest
import com.test.weather.core.functional.Either
import com.test.weather.core.interactor.UseCase
import com.test.weather.feature.forecast.response.ForecastResponse
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GetForecastTest : UnitTest() {

    private lateinit var getForecast: GetForecast

    @Mock
    private lateinit var weatherRepository: WeatherRepository

    @Before
    fun setUp() {
        getForecast = GetForecast(weatherRepository)
        given { weatherRepository.forecast() }.willReturn(Either.Right(ForecastResponse.empty()))
    }

    @Test
    fun `should get data from repository`() {
        runBlocking { getForecast.run(UseCase.None()) }

        verify(weatherRepository).forecast()
        verifyNoMoreInteractions(weatherRepository)
    }
}