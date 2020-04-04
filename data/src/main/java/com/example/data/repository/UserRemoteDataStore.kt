package com.example.data.repository

import com.example.data.model.api.UserApiModel
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataStore {

    suspend fun getUsers(): Flow<List<UserApiModel>>

    suspend fun getUsers(id: String): Flow<UserApiModel>
}