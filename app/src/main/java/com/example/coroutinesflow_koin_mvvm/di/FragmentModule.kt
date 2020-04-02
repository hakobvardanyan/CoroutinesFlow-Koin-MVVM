package com.example.coroutinesflow_koin_mvvm.di

import com.example.coroutinesflow_koin_mvvm.feature.employeeslist.EmployeesListFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val FRAGMENT_MODULE = module {

    fragment {
        EmployeesListFragment(
            get()
        )
    }

}