package com.example.data.service

import com.example.data.model.api.EmployeeApiModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface EmployeeApiService {

    @GET("employee")
    suspend fun getEmployees(): Flow<List<EmployeeApiModel>>

    @GET("employee/{id}")
    suspend fun getEmployee(@Path("id") id: String): Flow<EmployeeApiModel>

}