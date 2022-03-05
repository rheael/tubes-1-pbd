package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.*
import com.example.myapplication.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScannerViewModel (private val repository: Repository): ViewModel() {
    val myScanResults: MutableLiveData<ScanResults> = MutableLiveData()
    fun postScan(checkInBody: QrCode) {
        viewModelScope.launch {
            repository.postScan(checkInBody)
        }
    }
}