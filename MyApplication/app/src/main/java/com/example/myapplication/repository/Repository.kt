package com.example.myapplication.repository

import com.example.myapplication.api.RetrofitInstance
import com.example.myapplication.model.*

class Repository {
    suspend fun getResults(): Results {
        return RetrofitInstance.api.getResults()
    }
    suspend fun getProvince(): ProvinceResults {
        return RetrofitInstance.api.getProvince()
    }
    suspend fun getFaskes(province: String, city: String): FaskesResults {
        return RetrofitInstance.api.getFaskes(province, city)
    }
    suspend fun getCity(start_id: String): CityResults {
        return RetrofitInstance.api.getCity(start_id)
    }

    suspend fun postScan(checkInBody: QrCode): ScanResults {
        return RetrofitInstance.api.postScan(checkInBody)
    }
}