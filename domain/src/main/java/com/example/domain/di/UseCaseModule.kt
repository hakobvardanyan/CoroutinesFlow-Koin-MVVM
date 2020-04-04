package com.example.domain.di

import com.example.domain.user.LoadUserUseCase
import org.koin.dsl.module

val USE_CASE_MODULE = module {

    factory { LoadUserUseCase(get()) }

}