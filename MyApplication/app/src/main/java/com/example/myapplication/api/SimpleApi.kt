package com.example.myapplication.api

import com.example.myapplication.model.*
import retrofit2.http.GET
import retrofit2.http.*
import java.util.*


interface SimpleApi {
    @GET("get-news")
    suspend fun getResults(): Results;

    @GET("get-province")
    suspend fun getProvince(): ProvinceResults;

    @GET("get-faskes-vaksinasi")
    suspend fun getFaskes(@Query("province") province:String, @Query("city") city: String): FaskesResults;

    @GET("get-city")
    suspend fun getCity(@Query("start_id") province:String): CityResults;
}