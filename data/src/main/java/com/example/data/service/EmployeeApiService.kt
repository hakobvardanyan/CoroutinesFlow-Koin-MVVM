package com.example.data.service

import com.example.data.model.api.BaseApiModel
import com.example.data.model.api.EmployeeApiModel
import retrofit2.http.GET
import retrofit2.http.Path

interface EmployeeApiService {

    @GET("employees")
    suspend fun getEmployees(): BaseApiModel

    @GET("employee/{id}")
    suspend fun getEmployee(@Path("id") id: String): EmployeeApiModel

}