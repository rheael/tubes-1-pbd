package com.example.myapplication.model

data class FaskesResults (
    val success: String,
    val message: String,
    val count_total: Int,
    val data: List<Faskes>
)