package com.test.weather.core.exception

sealed class Failure {
    class NetworkConnection: Failure()
    class ServerError: Failure()
    abstract class FeatureFailure: Failure()
}