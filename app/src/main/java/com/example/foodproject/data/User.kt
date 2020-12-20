package com.example.foodproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userName: String,
    val address: String,
    val phoneNumber:String,
    val emailAddress:String,
    val password: String,
    var favorites: String = ""
)