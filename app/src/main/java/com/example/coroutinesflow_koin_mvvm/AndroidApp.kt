package com.example.coroutinesflow_koin_mvvm

import android.app.Application
import com.example.coroutinesflow_koin_mvvm.di.APP_DI_MODULES
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class AndroidApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@AndroidApp)
            modules(APP_DI_MODULES)
        }
    }

}