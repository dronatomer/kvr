package com.example.mykotlinproject.components

import com.example.movieapp.dagger.module.viewModule.ViewModelModule
import com.example.mykotlinproject.fragment.DetailFragment
import com.example.mykotlinproject.fragment.ListFragment.MyListFragment


import com.example.mykotlinproject.network.NetworkModule


import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent{

//    fun inject(overviewFragment: OverviewFragment)
    fun inject(detailFragment: DetailFragment)
    fun inject(mylistFragment: MyListFragment)
//    fun inject(newsFragment: NewsFragment)
//    fun inject(detailNewsFragment: DetailNewsFragment)
//    fun inject(settingsFragment: SettingsFragment)
//    fun inject(profileFragment: ProfileFragment)
}