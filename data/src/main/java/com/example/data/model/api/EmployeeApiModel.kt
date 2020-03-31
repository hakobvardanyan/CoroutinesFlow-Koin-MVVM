package com.example.data.model.api

import com.google.gson.annotations.SerializedName

data class EmployeeApiModel(
    @SerializedName(value = "id")
    val id: String,
    @SerializedName(value = "employee_age")
    val age: String,
    @SerializedName(value = "employee_name")
    val name: String,
    @SerializedName(value = "profile_image")
    val image: String,
    @SerializedName(value = "employee_salary")
    val salary: String
)