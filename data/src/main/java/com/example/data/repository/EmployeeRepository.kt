package com.example.data.repository

import com.example.data.model.api.EmployeeApiModel
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {

    suspend fun getEmployees(): Flow<List<EmployeeApiModel>>

}