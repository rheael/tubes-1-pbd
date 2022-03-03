package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.*
import com.example.myapplication.repository.Repository
import kotlinx.coroutines.launch

class SecondViewModel (private val repository: Repository): ViewModel() {
    val myProvinceResults: MutableLiveData<ProvinceResults> = MutableLiveData()
    val myFaskesResults: MutableLiveData<FaskesResults> = MutableLiveData()
    val myCityResults: MutableLiveData<CityResults> = MutableLiveData()
    fun getProvince() {
        viewModelScope.launch {
            val response = repository.getProvince()
            myProvinceResults.value = response
        }
    }
    fun getFaskes(province: String, city: String) {
        viewModelScope.launch {
            val response = repository.getFaskes(province, city)
            myFaskesResults.value = response
        }
    }
    fun getCity(start_id: String) {
        viewModelScope.launch {
            val response = repository.getCity(start_id)
            myCityResults.value = response
        }
    }
}