package com.example.coroutinesflow_koin_mvvm.di

import com.example.coroutinesflow_koin_mvvm.feature.employeeslist.UsersListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val VIEW_MODEL_MODULE = module {

    viewModel { UsersListViewModel(get()) }

}