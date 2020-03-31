package com.example.data.repository

import com.example.data.database.AppDatabase
import com.example.data.model.database.EmployeeDatabaseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class EmployeeLocalDataStoreImpl constructor(
    private val database: AppDatabase
) : EmployeeLocalDataStore {

    override suspend fun saveEmployees(employees: List<EmployeeDatabaseModel>): Flow<List<Long>> {
        return flowOf(database.employeeDao().insertEmployees(employees))
    }

    override suspend fun getEmployees(): Flow<List<EmployeeDatabaseModel>> {
        return database.employeeDao().loadEmployees()
    }

}