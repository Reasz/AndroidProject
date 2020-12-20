package com.example.foodproject.api

import android.os.Build.VERSION_CODES.BASE
import com.example.foodproject.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: RestaurantApi by lazy {
        retrofit.create(RestaurantApi::class.java)
    }

}