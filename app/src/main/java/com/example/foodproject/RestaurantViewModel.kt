package com.example.foodproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodproject.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class RestaurantViewModel(private val repository: Repository):ViewModel() {

    val myCityPosts: MutableLiveData<Response<RestaurantData>> = MutableLiveData()
    val myAllPost: MutableLiveData<Response<RestaurantData>> = MutableLiveData()


    fun getCityPosts(city: String) {
        viewModelScope.launch {
            val response :Response<RestaurantData> = repository.getCityPosts(city)
            myCityPosts.value = response
        }
    }

    fun getAllPosts() {
        viewModelScope.launch {
            val response :Response<RestaurantData> = repository.getAllPosts()
            myAllPost.value = response
        }
    }

}