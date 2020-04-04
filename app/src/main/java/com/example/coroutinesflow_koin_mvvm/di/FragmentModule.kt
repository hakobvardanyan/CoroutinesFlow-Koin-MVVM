package com.example.coroutinesflow_koin_mvvm.di

import com.example.coroutinesflow_koin_mvvm.feature.employeeslist.UsersListFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

@ExperimentalCoroutinesApi
@FlowPreview
val FRAGMENT_MODULE = module {

    fragment { UsersListFragment(get()) }

}