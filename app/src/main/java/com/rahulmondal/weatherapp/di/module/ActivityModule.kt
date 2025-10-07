package com.rahulmondal.weatherapp.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.rahulmondal.weatherapp.di.ActivityContext
import dagger.Provides

class ActivityModule(private val activity: AppCompatActivity) {
    @ActivityContext
    @Provides
    fun provideContext(): Context=activity


}