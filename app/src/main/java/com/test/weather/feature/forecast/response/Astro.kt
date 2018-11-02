package com.test.weather.feature.forecast.response

import com.google.gson.annotations.SerializedName

data class Astro(@SerializedName("moonset")
                 val moonset: String = "",
                 @SerializedName("sunrise")
                 val sunrise: String = "",
                 @SerializedName("sunset")
                 val sunset: String = "",
                 @SerializedName("moonrise")
                 val moonrise: String = "")