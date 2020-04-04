package com.example.coroutinesflow_koin_mvvm.feature.employeeslist

import androidx.lifecycle.ViewModel
import com.example.coroutinesflow_koin_mvvm.mapper.UserDataMapper
import com.example.coroutinesflow_koin_mvvm.viewdata.UserViewData
import com.example.domain.employee.LoadUserUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UsersListViewModel constructor(
    private val userUseCase: LoadUserUseCase
) : ViewModel() {

    suspend fun observeUsers(): Flow<List<UserViewData>> {
        return userUseCase.execute()
            .map { UserDataMapper.toViewData(it) }
    }

}
