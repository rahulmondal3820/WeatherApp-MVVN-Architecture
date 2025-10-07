package com.rahulmondal.weatherapp.di.component

import com.rahulmondal.weatherapp.MyApplication
import com.rahulmondal.weatherapp.data.repository.CurrentWeatherRepository
import com.rahulmondal.weatherapp.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: MyApplication)
    fun getWeatherRepository(): CurrentWeatherRepository
}