package com.example.data.repository

import com.example.data.model.api.EmployeeApiModel
import kotlinx.coroutines.flow.Flow

class EmployeeRepositoryImpl constructor(
    private val localDataStore: EmployeeLocalDataStore,
    private val remoteDataStore: EmployeeRemoteDataStore
) : EmployeeRepository {

    override suspend fun getEmployees(): Flow<List<EmployeeApiModel>> {
        return remoteDataStore.getEmployees()
    }
}