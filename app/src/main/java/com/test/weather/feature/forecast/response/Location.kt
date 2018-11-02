package com.test.weather.feature.forecast.response

import com.google.gson.annotations.SerializedName

data class Location(@SerializedName("localtime")
                    val localtime: String = "",
                    @SerializedName("country")
                    val country: String = "",
                    @SerializedName("localtime_epoch")
                    val localtimeEpoch: Int = 0,
                    @SerializedName("name")
                    val name: String = "",
                    @SerializedName("lon")
                    val lon: Double = 0.0,
                    @SerializedName("region")
                    val region: String = "",
                    @SerializedName("lat")
                    val lat: Double = 0.0,
                    @SerializedName("tz_id")
                    val tzId: String = "")