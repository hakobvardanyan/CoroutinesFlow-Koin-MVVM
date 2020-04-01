package com.example.domain.employee

import com.example.domain.FlowUseCase
import com.example.domain.model.EmployeeModel
import com.example.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow

class LoadEmployeeUseCase constructor(
    private val employeeRepository: EmployeeRepository
) : FlowUseCase<List<EmployeeModel>>() {

    override suspend fun execute(): Flow<List<EmployeeModel>> {
        return employeeRepository.getEmployees()
    }
}