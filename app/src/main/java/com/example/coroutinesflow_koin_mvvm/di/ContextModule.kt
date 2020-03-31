package com.example.coroutinesflow_koin_mvvm.di

import com.example.coroutinesflow_koin_mvvm.AndroidApp
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val CONTEXT_MODULE = module {

    single { androidApplication() as AndroidApp }

    single { androidApplication().contentResolver }
//
//    single { get<IApp>() as PrefUtils.UserIdentifierUpdateListener }
}
