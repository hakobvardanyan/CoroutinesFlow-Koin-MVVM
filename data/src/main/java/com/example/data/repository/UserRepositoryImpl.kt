package com.example.data.repository

import android.util.Log
import com.example.data.mapper.UserDataMapper
import com.example.domain.model.UserModel
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

@FlowPreview
class UserRepositoryImpl constructor(
    private val localDataStore: UserLocalDataStore,
    private val remoteDataStore: UserRemoteDataStore
) : UserRepository {

    override suspend fun getUsers(): Flow<List<UserModel>> {
        try {
            remoteDataStore.getUsers().collect {
                withContext(Dispatchers.IO) {
                    localDataStore.saveUsers(UserDataMapper.transformFromApiToDatabaseModel(it))
                        .collect()
                }
                Log.d(":::: ", "Saved fuck yeah!")
            }
        } catch (t: Throwable) {
            Log.d(":::: ", "Fucked up")
        }
        return localDataStore.getUsers().flatMapMerge {
            if (it.isNotEmpty()) {
                flowOf(UserDataMapper.transformFromDatabaseModel(it))
            } else {
                try {
                    remoteDataStore.getUsers().map { UserDataMapper.transformFromApiModel(it) }
                } catch (t: Throwable) {
                    flowOf(emptyList<UserModel>())
                }
            }
        }
    }
}