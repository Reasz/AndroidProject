package com.example.foodproject.api

import com.example.foodproject.RestaurantData
import com.example.foodproject.RestaurantItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantApi {

    @GET("restaurants")
    suspend fun getCityPost(
        @Query("city") city: String
    ): Response<RestaurantData>

    @GET("restaurants")
    suspend fun getAllPost():Response<RestaurantData>

}