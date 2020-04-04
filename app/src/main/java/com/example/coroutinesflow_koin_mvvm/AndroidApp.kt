package com.example.coroutinesflow_koin_mvvm

import android.app.Application
import com.example.coroutinesflow_koin_mvvm.di.APP_DI_MODULES
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin


@ExperimentalCoroutinesApi
@FlowPreview
class AndroidApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@AndroidApp)
            fragmentFactory()
            modules(APP_DI_MODULES)
        }
    }
}