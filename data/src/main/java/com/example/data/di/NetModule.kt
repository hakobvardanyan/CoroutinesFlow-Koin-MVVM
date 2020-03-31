package com.example.data.di

import com.example.data.service.EmployeeApiService
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val NET_MODULE = module {

    //    factory<AppService> { AppServiceImpl(get(), get(), get()) }
//
//    single { AuthApiService(get(), get(), get()) }
//
//    single { UserAPIService(get(), get()) }
//
//
//    single<SocketService> {
//        SocketServiceImpl(
//            SocketIoServiceImpl(get()),
//            WebSocketServiceImpl(WebSocketServiceDelegateImpl(get()))
//        )
//    }
//
//    single<UserRemoteDataStore> { UserremoteDataStoreImpl() }
//    single<UserLocalDataStore> { UserLocalDataStoreImpl() }
//    single<UserRepository> { UserRepositoryImpl(get(), get()) }

    single<EmployeeApiService> { get<Retrofit>().create(EmployeeApiService::class.java) }

    single {
        Retrofit.Builder()
            .baseUrl("http://dummy.restapiexample.com/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .build()
    }
}