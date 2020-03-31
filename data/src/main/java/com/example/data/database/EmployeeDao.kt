package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.database.EmployeeDatabaseModel
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployees(employees: List<EmployeeDatabaseModel>): List<Long>

    @Query("SELECT * FROM employee ORDER BY name ASC")
    fun loadEmployees(): Flow<List<EmployeeDatabaseModel>>

}