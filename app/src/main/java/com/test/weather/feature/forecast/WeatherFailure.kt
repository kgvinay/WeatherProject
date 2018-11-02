package com.test.weather.feature.forecast

import com.test.weather.core.exception.Failure

class WeatherFailure{
    class ListNotAvailable: Failure.FeatureFailure()
    class NonExistentMovie: Failure.FeatureFailure()
}