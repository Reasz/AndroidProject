/*package com.example.foodproject.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavoritesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavorite(favorite: Favorite)

    @Transaction
    @Query("SELECT * FROM user_table")
    fun getUsersAndLibraries(): List<UserAndFavorites>
}*/