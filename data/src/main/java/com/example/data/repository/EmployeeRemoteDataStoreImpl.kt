package com.example.data.repository

import com.example.data.model.api.EmployeeApiModel
import com.example.data.service.EmployeeApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

class EmployeeRemoteDataStoreImpl constructor(
    private val employeeService: EmployeeApiService
) : EmployeeRemoteDataStore {

    override suspend fun getEmployees(): Flow<List<EmployeeApiModel>> {
        return flowOf(employeeService.getEmployees().data)
    }

    override suspend fun getEmployee(id: String): Flow<EmployeeApiModel> {
        return flowOf(employeeService.getEmployee(id))
    }

}