package com.example.foodproject

data class RestaurantData (
    val total_entries: Int,
    val page: Int,
    val per_page: Int,
    val restaurants: List<RestaurantItem>
)