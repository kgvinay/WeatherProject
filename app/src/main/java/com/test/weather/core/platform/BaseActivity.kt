package com.test.weather.core.platform

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.test.weather.R
import com.test.weather.core.extension.inTransaction
import dagger.android.support.DaggerAppCompatActivity

import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        addFragment(savedInstanceState)
    }

    private fun addFragment(savedInstanceState: Bundle?) =
            savedInstanceState ?: supportFragmentManager.inTransaction { add(
                    R.id.fragmentContainer, fragment()) }

    abstract fun fragment(): BaseFragment

}
