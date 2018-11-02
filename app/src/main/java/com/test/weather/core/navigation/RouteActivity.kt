package com.test.weather.core.navigation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import javax.inject.Inject

class RouteActivity : AppCompatActivity() {


    @Inject
    internal lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.showMain(this)
    }
}