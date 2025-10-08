package com.rahulmondal.weatherapp.di.module;

import android.content.Context
import androidx.transition.Visibility;

import com.rahulmondal.weatherapp.MyApplication;
import com.rahulmondal.weatherapp.data.api.NetworkService
import com.rahulmondal.weatherapp.di.ApplicationContext
import com.rahulmondal.weatherapp.di.BaseUrl

import dagger.Module;
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application:MyApplication) {
    @ApplicationContext
    @Provides
    fun provideContext(): Context=application

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String=" https://api.weatherapi.com/v1/"

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory= GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideNetworkService(@BaseUrl baseUrl: String, converterFactory: GsonConverterFactory): NetworkService{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .build()
            .create(NetworkService::class.java)
    }
}
