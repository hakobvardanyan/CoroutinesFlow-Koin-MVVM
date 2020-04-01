package com.example.domain.repository

import com.example.domain.model.EmployeeModel
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {

    suspend fun getEmployees(): Flow<List<EmployeeModel>>

}