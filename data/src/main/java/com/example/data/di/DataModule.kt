package com.example.data.di

import com.example.data.repository.*
import com.example.domain.repository.UserRepository
import org.koin.dsl.module

val DATA_MODULE = module {

//    //ads
//    single<IAdsRepository> { AdsRepository(get(), get()) }
//    single<IAdsRemoteDataStore> { AdsRemoteDataStore(get()) }
//    single<IAdsLocalDataStore> { AdsLocalDataStore() }
//
    // employees
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
    single<UserLocalDataStore> { UserLocalDataStoreImpl(get()) }
    single<UserRemoteDataStore> { UserRemoteDataStoreImpl(get()) }

}