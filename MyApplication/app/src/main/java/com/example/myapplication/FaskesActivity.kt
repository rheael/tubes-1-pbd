package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FaskesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faskes)
        val nama: String = intent.getStringExtra("nama").toString()
        val kode: String = intent.getStringExtra("kode").toString()
        val alamat: String = intent.getStringExtra("alamat").toString()
        val jenis_faskes: String = intent.getStringExtra("jenis_faskes").toString()
        val status: String = intent.getStringExtra("status").toString()
        val telp: String = intent.getStringExtra("telp").toString()
        val namaTV: TextView = findViewById(R.id.nama_faskes)
        val kodeTV: TextView = findViewById(R.id.kode_faskes)
        val alamatTV: TextView = findViewById(R.id.alamat_faskes)
        val jenisTV: TextView = findViewById(R.id.jenis_faskes)
        val statusTV: TextView = findViewById(R.id.status)
        val telpTV: TextView = findViewById(R.id.nomor_telepon)
        Log.d("nama",nama);
        Log.d("nama",kode);
        Log.d("nama",alamat);
        Log.d("nama",jenis_faskes);
        Log.d("nama",status);
        Log.d("nama",telp);
        namaTV.setText(nama);
        kodeTV.setText(kode);
        alamatTV.setText(alamat);
        jenisTV.setText(jenis_faskes);
        statusTV.setText(status);
        telpTV.setText(telp);
        // val namaTV textView = findViewById(R.id.nama_faskes);
        /*
        intent.putExtra("kode", myList[position].kode)
        intent.putExtra("alamat", myList[position].alamat)
        intent.putExtra("telp", myList[position].telp)
        intent.putExtra("jenis_faskes", myList[position].jenis_faskes)
        intent.putExtra("status", myList[position].status) */
    }
}
