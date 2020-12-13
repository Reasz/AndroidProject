package com.example.foodproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_table")
data class Restaurant (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val address: String,
    val image: String,
    val price: String,
    val city: String
)