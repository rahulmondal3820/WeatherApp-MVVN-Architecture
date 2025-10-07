package com.rahulmondal.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("temp_c")
    val temp: Int = 0,
    @SerializedName("last_updated")
    val lastUpdate: String="",
    @SerializedName("wind_kph")
    val windSpeed: Int=0,
    @SerializedName("humidity")
    val humidity: Int=0,
    @SerializedName("cloud")
    val cloudPercent:Int =0
)
