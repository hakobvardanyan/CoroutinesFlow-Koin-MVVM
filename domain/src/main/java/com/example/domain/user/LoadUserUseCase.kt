package com.example.domain.user

import com.example.domain.FlowUseCase
import com.example.domain.model.UserModel
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class LoadUserUseCase constructor(
    private val userRepository: UserRepository
) : FlowUseCase<List<UserModel>>() {

    override suspend fun execute(): Flow<List<UserModel>> {
        return userRepository.getUsers()
    }
}