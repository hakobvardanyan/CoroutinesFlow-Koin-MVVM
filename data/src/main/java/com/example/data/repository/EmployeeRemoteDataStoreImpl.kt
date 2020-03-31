package com.example.data.repository

import com.example.data.model.api.EmployeeApiModel
import com.example.data.service.EmployeeApiService
import kotlinx.coroutines.flow.Flow

class EmployeeRemoteDataStoreImpl constructor(
    private val employeeService: EmployeeApiService
) : EmployeeRemoteDataStore {

    override suspend fun getEmployees(): Flow<List<EmployeeApiModel>> {
        return employeeService.getEmployees()
    }

    override suspend fun getEmployee(id: String): Flow<EmployeeApiModel> {
        return employeeService.getEmployee(id)
    }

}