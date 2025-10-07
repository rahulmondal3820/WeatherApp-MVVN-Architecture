package com.rahulmondal.weatherapp.data.api

import com.rahulmondal.weatherapp.data.model.CurrentWeatherResponse
import com.rahulmondal.weatherapp.utils.AppConstant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetworkService {
    @Headers("key: $API_KEY")
    @GET("current.json")
    suspend fun getCurrentWeatherResponse(@Query("q") country: String): CurrentWeatherResponse
}