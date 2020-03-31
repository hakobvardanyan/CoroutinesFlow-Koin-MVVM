package com.example.coroutinesflow_koin_mvvm.di

import com.example.data.di.DATA_MODULE
import com.example.data.di.DB_MODULE
import com.example.data.di.NET_MODULE
import com.example.domain.USE_CASE_MODULE

val APP_DI_MODULES = listOf(
    CONTEXT_MODULE,
    MODEL_MODULE,
    NAVIGATION_MODULE,
    VIEW_MODEL_MODULE,
    DATA_MODULE,
    DB_MODULE,
    NET_MODULE,
    USE_CASE_MODULE
)