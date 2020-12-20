package com.example.foodproject

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestaurantItem(
    val id: Int,
    val name: String,
    val address: String,
    val city: String,
    val state: String,
    val area: String,
    val postal_code:String,
    val country:String,
    val phone:Number,
    val lat:Number,
    val lng:Number,
    val price:String,
    val reserve_url:String,
    val mobile_reserve_url: String,
    val image_url:String
) : Parcelable