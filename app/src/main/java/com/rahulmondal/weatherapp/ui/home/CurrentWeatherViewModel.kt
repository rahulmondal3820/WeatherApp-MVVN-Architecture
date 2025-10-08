package com.rahulmondal.weatherapp.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahulmondal.weatherapp.data.model.CurrentWeatherResponse
import com.rahulmondal.weatherapp.data.repository.CurrentWeatherRepository
import com.rahulmondal.weatherapp.ui.base.UiState
import com.rahulmondal.weatherapp.utils.AppConstant.COUNTRY
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CurrentWeatherViewModel(private val repository: CurrentWeatherRepository): ViewModel() {
    private val _uiState= MutableStateFlow<UiState<CurrentWeatherResponse>>(UiState.Loading)
    val uiState: StateFlow<UiState<CurrentWeatherResponse>> =_uiState
    init {
        fetchCurrentWeather()
    }
    private fun fetchCurrentWeather(){
        viewModelScope.launch {
            repository.getCurrentWeatherDetails(COUNTRY).catch {
                _uiState.value= UiState.Error(it.toString())
            }.collect {
                _uiState.value= UiState.Success(it)

            }
        }
    }
}