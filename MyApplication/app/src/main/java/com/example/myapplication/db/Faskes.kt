package com.example.myapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Faskes(
    @ColumnInfo(name = "nama") val nama: String,
    @ColumnInfo(name = "kode") val kode: String,
    @ColumnInfo(name = "alamat") val alamat: String,
    @ColumnInfo(name = "nomor") val nomor: String,
    @ColumnInfo(name = "jenis") val jenis: String,
    @ColumnInfo(name = "status") val status: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}