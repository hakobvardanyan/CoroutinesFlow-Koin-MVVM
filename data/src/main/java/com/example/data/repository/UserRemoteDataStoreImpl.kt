package com.example.data.repository

import com.example.data.model.api.UserApiModel
import com.example.data.service.UserApiService
import kotlinx.coroutines.flow.*

class UserRemoteDataStoreImpl constructor(
    private val userService: UserApiService
) : UserRemoteDataStore {

    override suspend fun getUsers(): Flow<List<UserApiModel>> {
        return flowOf(userService.getUsers())
    }

    override suspend fun getUsers(id: String): Flow<UserApiModel> {
        return flowOf(userService.getUser(id))
    }

}