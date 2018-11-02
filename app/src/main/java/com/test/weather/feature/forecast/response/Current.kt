package com.test.weather.feature.forecast.response

import com.google.gson.annotations.SerializedName

data class Current(@SerializedName("feelslike_c")
                   val feelslikeC: Double = 0.0,
                   @SerializedName("last_updated")
                   val lastUpdated: String = "",
                   @SerializedName("feelslike_f")
                   val feelslikeF: Double = 0.0,
                   @SerializedName("wind_degree")
                   val windDegree: Double = 0.0,
                   @SerializedName("last_updated_epoch")
                   val lastUpdatedEpoch: Double = 0.0,
                   @SerializedName("is_day")
                   val isDay: Double = 0.0,
                   @SerializedName("precip_in")
                   val precipIn: Double = 0.0,
                   @SerializedName("wind_dir")
                   val windDir: String = "",
                   @SerializedName("temp_c")
                   val tempC: Double = 0.0,
                   @SerializedName("pressure_in")
                   val pressureIn: Double = 0.0,
                   @SerializedName("temp_f")
                   val tempF: Double = 0.0,
                   @SerializedName("precip_mm")
                   val precipMm: Double = 0.0,
                   @SerializedName("cloud")
                   val cloud: Double = 0.0,
                   @SerializedName("wind_kph")
                   val windKph: Double = 0.0,
                   @SerializedName("condition")
                   val condition: Condition,
                   @SerializedName("wind_mph")
                   val windMph: Double = 0.0,
                   @SerializedName("vis_km")
                   val visKm: Double = 0.0,
                   @SerializedName("humidity")
                   val humidity: Double = 0.0,
                   @SerializedName("pressure_mb")
                   val pressureMb: Double = 0.0,
                   @SerializedName("vis_miles")
                   val visMiles: Double = 0.0)