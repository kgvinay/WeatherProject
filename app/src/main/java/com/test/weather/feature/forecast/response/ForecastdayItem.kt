package com.test.weather.feature.forecast.response

import com.google.gson.annotations.SerializedName

data class ForecastdayItem(@SerializedName("date")
                           val date: String = "",
                           @SerializedName("astro")
                           val astro: Astro,
                           @SerializedName("date_epoch")
                           val dateEpoch: Int = 0,
                           @SerializedName("day")
                           val day: Day) {

}