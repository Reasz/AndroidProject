package com.example.foodproject.repository

import com.example.foodproject.RestaurantData
import com.example.foodproject.RestaurantItem
import com.example.foodproject.api.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun getPost():Response<RestaurantItem> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<RestaurantItem> {
        return  RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPosts(city: String): Response<List<RestaurantItem>> {
        return RetrofitInstance.api.getCustomPost(city)
    }

    suspend fun getCustomPosts2():Response<RestaurantData> {
        return RetrofitInstance.api.getPost2()
    }
}