package com.example.data.repository

import com.example.data.model.database.EmployeeDatabaseModel
import kotlinx.coroutines.flow.Flow

interface EmployeeLocalDataStore {

    suspend fun saveEmployees(employees: List<EmployeeDatabaseModel>): Flow<List<Long>>

    suspend fun getEmployees(): Flow<List<EmployeeDatabaseModel>>

}