package com.example.domain

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<T> : BaseUseCase() {

    abstract suspend fun execute(): Flow<T>

}