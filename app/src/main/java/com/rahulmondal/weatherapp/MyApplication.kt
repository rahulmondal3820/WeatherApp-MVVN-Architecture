package com.rahulmondal.weatherapp

import android.app.Application
import com.rahulmondal.weatherapp.di.component.ApplicationComponent
import com.rahulmondal.weatherapp.di.component.DaggerApplicationComponent
import com.rahulmondal.weatherapp.di.module.ApplicationModule

class MyApplication: Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }
    private fun injectDependencies(){
        applicationComponent= DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)

    }
}