package com.example.cleanmvvmkoin.di

import com.example.cleanmvvmkoin.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            setStringUseCase = get(),
            getStringUseCase = get()
        )
    }
}