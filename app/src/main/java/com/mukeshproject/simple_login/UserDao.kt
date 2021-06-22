package com.mukeshproject.simple_login

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Query("Select Email From Users_DB Where Email=:email")
    fun getUserEmail(email: String): String

    @Query("Select * From Users_DB Where Email=:email" )
    fun getUsersPassword(email:String): User

}