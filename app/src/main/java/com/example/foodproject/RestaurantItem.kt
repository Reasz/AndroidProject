package com.example.foodproject

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestaurantItem(
    val imageResource: Int,
    val title: String,
    val address: String,
    val price: String
) : Parcelable