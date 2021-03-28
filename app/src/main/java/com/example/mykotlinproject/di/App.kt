package com.example.mykotlinproject.di

import android.app.Application
import com.example.mykotlinproject.components.AppComponent
import com.example.mykotlinproject.components.DaggerAppComponent
import com.example.mykotlinproject.network.NetworkModule

class App : Application(){

    companion object{ lateinit var appComponent: AppComponent }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .networkModule(NetworkModule(this))
            .build()
    }
}