package com.rahulmondal.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("temp_c")
    val temp: Float = 0f,
    @SerializedName("last_updated")
    val lastUpdate: String="",
    @SerializedName("wind_kph")
    val windSpeed: Float=0f,
    @SerializedName("humidity")
    val humidity: Int=0,
    @SerializedName("cloud")
    val cloudPercent:Int =0
)
