package com.rahulmondal.weatherapp.di.component

import com.rahulmondal.weatherapp.ui.home.HomePageActivity
import com.rahulmondal.weatherapp.di.ActivityScope
import com.rahulmondal.weatherapp.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    fun inject(activity: HomePageActivity)
}