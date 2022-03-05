package com.example.myapplication.model

data class ScanResults(
    val success: String,
    val code: Int,
    val message: String,
    val data: DataScanner
)