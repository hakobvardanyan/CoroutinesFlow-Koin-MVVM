package com.example.data.repository

import com.example.data.model.database.UserDatabaseModel
import kotlinx.coroutines.flow.Flow

interface UserLocalDataStore {

    suspend fun saveUsers(employees: List<UserDatabaseModel>): Flow<List<Long>>

    suspend fun getUsers(): Flow<List<UserDatabaseModel>>

}