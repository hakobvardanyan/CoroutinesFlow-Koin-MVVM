package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.database.EmployeeDatabaseModel

@Database(
    entities = [
        EmployeeDatabaseModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
}
