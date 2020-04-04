package com.example.domain

import kotlinx.coroutines.flow.Flow

abstract class FlowParameterisedUseCase<P, T> : BaseUseCase() {

    abstract suspend fun execute(params: P): Flow<T>
}