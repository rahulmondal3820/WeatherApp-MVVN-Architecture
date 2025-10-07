package com.rahulmondal.weatherapp.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ActivityContext
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApplicationContext