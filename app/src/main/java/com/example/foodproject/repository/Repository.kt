package com.example.foodproject.repository

import com.example.foodproject.RestaurantData
import com.example.foodproject.RestaurantItem
import com.example.foodproject.api.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun getCityPosts(city: String): Response<RestaurantData> {
        return RetrofitInstance.api.getCityPost(city)
    }

    suspend fun getAllPosts():Response<RestaurantData> {
        return RetrofitInstance.api.getAllPost()
    }
}