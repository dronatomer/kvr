package com.example.movieapp.dagger.module.viewModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mykotlinproject.fragment.ListFragment.ListViewModel
import com.example.mykotlinproject.utils.ViewModelKey


import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(OverviewViewModel::class)
//    internal abstract fun bindOverviewViewModel(viewModel: OverviewViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(DetailViewModel::class)
//    internal abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(NewsViewModel::class)
//    internal abstract fun bindNewsViewModel(viewModel: NewsViewModel): ViewModel
//
    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    internal abstract fun bindListViewModel(viewModel: ListViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(DetailNewsViewModel::class)
//    internal abstract fun bindDetailNewsViewModel(viewModel: DetailNewsViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(ProfileViewModel::class)
//    internal abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}