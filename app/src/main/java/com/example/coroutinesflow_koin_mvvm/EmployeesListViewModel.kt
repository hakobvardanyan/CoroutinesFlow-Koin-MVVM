package com.example.coroutinesflow_koin_mvvm

import androidx.lifecycle.ViewModel
import com.example.domain.employee.LoadEmployeeUseCase
import com.example.domain.model.EmployeeModel
import kotlinx.coroutines.flow.Flow

class EmployeesListViewModel constructor(
    private val employeeUseCase: LoadEmployeeUseCase
) : ViewModel() {

    suspend fun observeEmployers(): Flow<List<EmployeeModel>> {
        return employeeUseCase.execute()
    }

}
