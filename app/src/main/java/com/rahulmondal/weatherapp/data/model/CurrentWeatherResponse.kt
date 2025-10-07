package com.rahulmondal.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("location")
    val location: Location,
    @SerializedName("current")
    val current: Current

)
