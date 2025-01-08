package com.example.trendvault.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.trendvault.Model.CategoryModel
import com.example.trendvault.Model.SliderModel
import com.example.trendvault.Repository.MainRepository

//expose the banner data to the UI in a lifecycle-aware manner while abstracting away the logic of data retrieval from Firebase.
class MainViewModel():ViewModel() {
    private val repository = MainRepository()
    fun loadBanner(): LiveData<MutableList<SliderModel>> {
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()

    }
}