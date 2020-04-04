package com.example.data.repository

import com.example.data.mapper.UserDataMapper
import com.example.domain.model.UserModel
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

@FlowPreview
class UserRepositoryImpl constructor(
    private val localDataStore: UserLocalDataStore,
    private val remoteDataStore: UserRemoteDataStore
) : UserRepository {

    override suspend fun getUsers(): Flow<List<UserModel>> {
        syncUsers()
        return localDataStore.getUsers()
            .map { UserDataMapper.transformFromDatabaseModel(it) }
    }

    private suspend fun syncUsers() {
        try {
            remoteDataStore.getUsers().collect {
                withContext(Dispatchers.IO) {
                    localDataStore
                        .saveUsers(UserDataMapper.transformFromApiToDatabaseModel(it))
                        .collect()
                }
            }
        } catch (t: Throwable) {
            println(t.message)
        }
    }
}