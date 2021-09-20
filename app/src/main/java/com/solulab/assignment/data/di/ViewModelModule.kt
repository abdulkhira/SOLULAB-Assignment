package com.solulab.assignment.data.di

import com.solulab.assignment.data.viewmodels.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { MainViewModel() }
}