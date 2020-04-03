package com.example.data.service

import com.example.data.model.api.UserApiModel
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {

    @GET("users")
    suspend fun getUsers(): List<UserApiModel>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: String): UserApiModel
}