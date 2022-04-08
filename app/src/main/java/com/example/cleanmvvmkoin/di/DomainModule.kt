package com.example.cleanmvvmkoin.di

import com.example.cleanmvvmkoin.domain.usecase.GetStringUseCase
import com.example.cleanmvvmkoin.domain.usecase.SetStringUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<SetStringUseCase> {
        SetStringUseCase(stringRepository = get())
    }

    factory<GetStringUseCase> {
        GetStringUseCase(stringRepository = get())
    }
}