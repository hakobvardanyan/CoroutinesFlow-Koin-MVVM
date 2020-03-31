package com.example.data.repository

import com.example.data.model.api.EmployeeApiModel
import kotlinx.coroutines.flow.Flow

interface EmployeeRemoteDataStore {

    suspend fun getEmployees(): Flow<List<EmployeeApiModel>>

    suspend fun getEmployee(id: String): Flow<EmployeeApiModel>

}