package com.example.foodproject.api

import com.example.foodproject.RestaurantData
import com.example.foodproject.RestaurantItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantApi {

    @GET("restaurants/1281")  //restaurants/1281
    suspend fun getPost():Response<RestaurantItem>

    @GET("restaurants/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number:  Int
    ):Response<RestaurantItem>

    @GET("restaurants")
    suspend fun getCustomPost(
        @Query("city") city: String
    ): Response<List<RestaurantItem>>

    @GET("restaurants")
    suspend fun getPost2():Response<RestaurantData>

}