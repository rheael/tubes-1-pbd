package com.example.myapplication.model

data class Post(
    val title: String,
    val link: List<String>,
    val guid: String,
    val pubDate: String,
    val description: Description,
    val enclosure: Enclosure,
    /* val id: Int,
    val userId: Int,
    val kode: Int,
    val title: String,
    val body: String */
    /*
    val nama: String,
    val kota: String,
    val provinsi: String,
    val alamat: String,
    val latitude: Int,
    val longitude: Int,
    val telp: String,
    val jenis_faskes: String,
    val kelas_rs: String,
    val status: String,
    val detail: String,
    val source_data: String*/
)