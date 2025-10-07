package com.rahulmondal.weatherapp.data.repository

import com.rahulmondal.weatherapp.data.api.NetworkService
import com.rahulmondal.weatherapp.data.model.Current
import com.rahulmondal.weatherapp.data.model.CurrentWeatherResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.text.Normalizer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrentWeatherRepository @Inject constructor(private val networkService: NetworkService) {
    fun getCurrentWeatherDetails( country: String): Flow<CurrentWeatherResponse>{
       return flow {
            emit(networkService.getCurrentWeatherResponse(country))
        }

    }

}