package com.example.foodproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodproject.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class RestaurantViewModel(private val repository: Repository):ViewModel() {

    val myResponse: MutableLiveData<Response<RestaurantItem>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<RestaurantItem>> = MutableLiveData()
    val myCustomPosts: MutableLiveData<Response<List<RestaurantItem>>> = MutableLiveData()
    val myCustomPosts2: MutableLiveData<Response<RestaurantData>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(city: String) {
        viewModelScope.launch {
            val response :Response<List<RestaurantItem>> = repository.getCustomPosts(city)
            myCustomPosts.value = response
        }
    }

    fun getCustommPosts2() {
        viewModelScope.launch {
            val response :Response<RestaurantData> = repository.getCustomPosts2()
            myCustomPosts2.value = response
        }
    }

}