package com.rahulmondal.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val name: String="",
    @SerializedName("localtime")
    val localTime:String =""
)
