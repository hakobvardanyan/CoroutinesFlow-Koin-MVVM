package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.database.UserDatabaseModel
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<UserDatabaseModel>): List<Long>

    @Query("SELECT * FROM user ORDER BY name ASC")
    fun loadUsers(): Flow<List<UserDatabaseModel>>
}