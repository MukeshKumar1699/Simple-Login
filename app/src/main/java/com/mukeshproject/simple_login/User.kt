package com.mukeshproject.simple_login

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users_DB")
data class User (

    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "Name")
    val firstName: String,

    @ColumnInfo(name = "Email")
    val email: String,

    @ColumnInfo(name = "Password")
    val password: String
        )