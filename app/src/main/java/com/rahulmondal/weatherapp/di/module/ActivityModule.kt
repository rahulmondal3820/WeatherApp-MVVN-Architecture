package com.rahulmondal.weatherapp.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rahulmondal.weatherapp.data.repository.CurrentWeatherRepository
import com.rahulmondal.weatherapp.di.ActivityContext
import com.rahulmondal.weatherapp.ui.base.ViewModelProviderFactory
import com.rahulmondal.weatherapp.ui.home.CurrentWeatherViewModel
import dagger.Module
import dagger.Provides
@Module
class ActivityModule(private val activity: AppCompatActivity) {
    @ActivityContext
    @Provides
    fun provideContext(): Context=activity
    @Provides
    fun provideCurrentWeatherViewModel(repository: CurrentWeatherRepository): CurrentWeatherViewModel{
        return ViewModelProvider(
            activity, ViewModelProviderFactory(CurrentWeatherViewModel::class) {
                CurrentWeatherViewModel(repository)
            }
        )[CurrentWeatherViewModel::class.java]
    }


}