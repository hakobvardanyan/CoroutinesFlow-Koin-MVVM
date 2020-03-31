package com.example.data.di

import androidx.room.Room
import com.example.data.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val DATABASE_NAME = "AppDatabase"

val DB_MODULE = module {

//    factory { AppDbCleanHelper(get(named<BaseEntity>())) }
//
//    single(named<BaseEntity>()) {
//        val context = androidContext()
//        MyObjectBox
//                .builder()
//                .androidContext(context)
//                .maxReaders(1000)
//                .build()
//    }

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}