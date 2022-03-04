package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.*
import com.example.myapplication.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel (private val repository: Repository): ViewModel() {
    val myResponse: MutableLiveData<Results> = MutableLiveData()
    fun getResults() {
        viewModelScope.launch {
            val response = repository.getResults()
            myResponse.value = response
        }
    }
}