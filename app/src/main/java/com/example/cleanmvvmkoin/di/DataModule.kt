package com.example.cleanmvvmkoin.di

import com.example.cleanmvvmkoin.data.repository.StringRepositoryImpl
import com.example.cleanmvvmkoin.data.storage.StringStorage
import com.example.cleanmvvmkoin.data.storage.sharedprefs.StringStorageImpl
import com.example.cleanmvvmkoin.domain.repository.StringRepository
import org.koin.dsl.module

val dataModule = module {

    single<StringStorage> {
        StringStorageImpl(context = get())
    }

    single<StringRepository> {
        StringRepositoryImpl(stringStorage = get())
    }
}