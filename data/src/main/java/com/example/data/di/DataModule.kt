package com.example.data.di

import com.example.data.repository.*
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.FlowPreview
import org.koin.dsl.module

@FlowPreview
val DATA_MODULE = module {

    // users
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
    single<UserLocalDataStore> { UserLocalDataStoreImpl(get()) }
    single<UserRemoteDataStore> { UserRemoteDataStoreImpl(get()) }

}