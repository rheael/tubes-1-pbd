package com.example.myapplication.model

data class Results (
    val success: String,
    val message: String,
    val count_total: Int,
    val results: List<Post>
)