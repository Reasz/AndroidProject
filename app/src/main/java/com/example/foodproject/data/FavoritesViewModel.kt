/*package com.example.foodproject.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application):AndroidViewModel(application) {

    val readAllData: LiveData<List<Favorite>>
    private val repository:FavoritesRepository

    init {
        var favoritesDao = FavoritesDatabase.getDatabase(application).favoritesDao()
        repository = FavoritesRepository(favoritesDao)
        readAllData = repository.readAllData
    }

    // Dispatchers.IO so it will be run in a background/worker thread
    fun addFavorites(favorite:Favorite){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFavorite(favorite)
        }
    }

}*/