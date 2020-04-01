package com.example.domain.di

import com.example.domain.employee.LoadEmployeeUseCase
import org.koin.dsl.module

val USE_CASE_MODULE = module {

    factory { LoadEmployeeUseCase(get()) }

}