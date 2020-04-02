package com.example.coroutinesflow_koin_mvvm.di

import com.example.coroutinesflow_koin_mvvm.EmployeesListFragment
import com.example.coroutinesflow_koin_mvvm.EmployeesListViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val FRAGMENT_MODULE = module {

    fragment { EmployeesListFragment(get()) }

}