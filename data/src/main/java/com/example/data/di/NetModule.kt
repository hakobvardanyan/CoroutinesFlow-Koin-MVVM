package com.example.data.di

import com.example.data.service.EmployeeApiService
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://dummy.restapiexample.com/api/v1/"

val NET_MODULE = module {

    single<EmployeeApiService> { get<Retrofit>().create(EmployeeApiService::class.java) }

    single<Retrofit> {
        val gson = GsonBuilder().setLenient().create()
        val logging = HttpLoggingInterceptor().setLevel(Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(logging).build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .client(client)
            .build()
    }
}