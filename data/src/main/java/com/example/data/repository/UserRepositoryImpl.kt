package com.example.data.repository

import com.example.data.mapper.UserDataMapper
import com.example.domain.model.UserModel
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl constructor(
    private val localDataStore: UserLocalDataStore,
    private val remoteDataStore: UserRemoteDataStore
) : UserRepository {

    override suspend fun getUsers(): Flow<List<UserModel>> {
        return remoteDataStore.getUsers().map {
            UserDataMapper.transform(it)
        }
    }
}