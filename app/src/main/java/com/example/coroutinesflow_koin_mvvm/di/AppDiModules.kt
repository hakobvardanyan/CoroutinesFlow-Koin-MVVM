package com.example.coroutinesflow_koin_mvvm.di

import com.example.data.di.DATA_MODULE
import com.example.data.di.DB_MODULE
import com.example.data.di.NET_MODULE
import com.example.domain.di.USE_CASE_MODULE
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
val APP_DI_MODULES = listOf(
    DB_MODULE,
    NET_MODULE,
    DATA_MODULE,
    MODEL_MODULE,
    CONTEXT_MODULE,
    USE_CASE_MODULE,
    FRAGMENT_MODULE,
    VIEW_MODEL_MODULE
)