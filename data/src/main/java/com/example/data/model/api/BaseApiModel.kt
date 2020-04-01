package com.example.data.model.api

import com.google.gson.annotations.SerializedName

data class BaseApiModel(
    @SerializedName(value = "status")
    val status: String,
    @SerializedName(value = "data")
    val data: List<EmployeeApiModel>
)