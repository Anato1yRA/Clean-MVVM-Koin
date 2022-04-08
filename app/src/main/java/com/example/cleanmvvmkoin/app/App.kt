package com.example.cleanmvvmkoin.app

import android.app.Application
import com.example.cleanmvvmkoin.di.appModule
import com.example.cleanmvvmkoin.di.dataModule
import com.example.cleanmvvmkoin.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}