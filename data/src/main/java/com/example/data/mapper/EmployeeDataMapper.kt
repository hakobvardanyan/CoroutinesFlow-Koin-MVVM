package com.example.data.mapper

import com.example.data.model.api.EmployeeApiModel
import com.example.domain.model.EmployeeModel

object EmployeeDataMapper {

    fun transform(from: EmployeeApiModel): EmployeeModel {
        return EmployeeModel(
            id = from.id,
            age = from.age,
            name = from.name,
            image = from.image,
            salary = from.salary
        )
    }

    fun transform(from: List<EmployeeApiModel>): List<EmployeeModel> {
        return from.map { transform(it) }
    }

}