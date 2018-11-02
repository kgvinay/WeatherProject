package com.test.weather.feature.forecast.response

import com.google.gson.annotations.SerializedName

data class Current(@SerializedName("feelslike_c")
                   val feelslikeC: Int = 0,
                   @SerializedName("last_updated")
                   val lastUpdated: String = "",
                   @SerializedName("feelslike_f")
                   val feelslikeF: Int = 0,
                   @SerializedName("wind_degree")
                   val windDegree: Int = 0,
                   @SerializedName("last_updated_epoch")
                   val lastUpdatedEpoch: Int = 0,
                   @SerializedName("is_day")
                   val isDay: Int = 0,
                   @SerializedName("precip_in")
                   val precipIn: Int = 0,
                   @SerializedName("wind_dir")
                   val windDir: String = "",
                   @SerializedName("temp_c")
                   val tempC: Int = 0,
                   @SerializedName("pressure_in")
                   val pressureIn: Double = 0.0,
                   @SerializedName("temp_f")
                   val tempF: Int = 0,
                   @SerializedName("precip_mm")
                   val precipMm: Int = 0,
                   @SerializedName("cloud")
                   val cloud: Int = 0,
                   @SerializedName("wind_kph")
                   val windKph: Int = 0,
                   @SerializedName("condition")
                   val condition: Condition,
                   @SerializedName("wind_mph")
                   val windMph: Int = 0,
                   @SerializedName("vis_km")
                   val visKm: Int = 0,
                   @SerializedName("humidity")
                   val humidity: Int = 0,
                   @SerializedName("pressure_mb")
                   val pressureMb: Int = 0,
                   @SerializedName("vis_miles")
                   val visMiles: Int = 0)