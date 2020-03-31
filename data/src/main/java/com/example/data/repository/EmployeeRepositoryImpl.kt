package com.example.data.repository

class EmployeeRepositoryImpl constructor(
    private val localDataStore: EmployeeLocalDataStore,
    private val remoteDataStore: EmployeeRemoteDataStore
) : EmployeeRepository {

}