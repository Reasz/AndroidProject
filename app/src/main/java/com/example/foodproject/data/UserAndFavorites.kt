/*package com.example.foodproject.data

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndFavorites (
    @Embedded val user:User,
    @Relation(
        parentColumn = "id",
        entityColumn = "favoriteID"
    )
    val favorite: Favorite
)*/