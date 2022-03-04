package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.myapplication.db.BookDatabase
import com.example.myapplication.db.Faskes
import com.example.myapplication.db.FaskesDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FaskesActivity : AppCompatActivity() {
    lateinit var db: FaskesDatabase
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
        val button: Button = findViewById(R.id.button_bookmark);
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
        Log.d("nama",nama);
        db = Room.databaseBuilder(applicationContext, FaskesDatabase::class.java, "faskes-db").build()
        button.setOnClickListener() {
            addBookmark(Faskes(nama, kode, alamat, jenis_faskes, status, telp))
        }
        // val namaTV textView = findViewById(R.id.nama_faskes);
        /*
        intent.putExtra("kode", myList[position].kode)
        intent.putExtra("alamat", myList[position].alamat)
        intent.putExtra("telp", myList[position].telp)
        intent.putExtra("jenis_faskes", myList[position].jenis_faskes)
        intent.putExtra("status", myList[position].status) */
    }
    fun addBookmark(faskes: Faskes) {
        GlobalScope.launch {
            db.faskesDao().insert(faskes)
        }
    }
}
