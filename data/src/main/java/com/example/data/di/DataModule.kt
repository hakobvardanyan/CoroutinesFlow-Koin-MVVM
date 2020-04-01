package com.example.data.di

import com.example.data.repository.*
import com.example.domain.repository.EmployeeRepository
import org.koin.dsl.module

val DATA_MODULE = module {

//    //ads
//    single<IAdsRepository> { AdsRepository(get(), get()) }
//    single<IAdsRemoteDataStore> { AdsRemoteDataStore(get()) }
//    single<IAdsLocalDataStore> { AdsLocalDataStore() }
//
    // employees
    single<EmployeeRepository> { EmployeeRepositoryImpl(get(), get()) }
    single<EmployeeLocalDataStore> { EmployeeLocalDataStoreImpl(get()) }
    single<EmployeeRemoteDataStore> { EmployeeRemoteDataStoreImpl(get()) }

}