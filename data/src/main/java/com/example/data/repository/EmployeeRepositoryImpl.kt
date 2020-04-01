package com.example.data.repository

import com.example.data.mapper.EmployeeDataMapper
import com.example.domain.model.EmployeeModel
import com.example.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EmployeeRepositoryImpl constructor(
    private val localDataStore: EmployeeLocalDataStore,
    private val remoteDataStore: EmployeeRemoteDataStore
) : EmployeeRepository {

    override suspend fun getEmployees(): Flow<List<EmployeeModel>> {
        return remoteDataStore.getEmployees().map {
            EmployeeDataMapper.transform(it)
        }
    }
}