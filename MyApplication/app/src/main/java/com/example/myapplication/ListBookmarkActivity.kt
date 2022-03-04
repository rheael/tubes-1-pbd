package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.myapplication.db.Book
import com.example.myapplication.db.Faskes
import com.example.myapplication.db.FaskesDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListBookmarkActivity : AppCompatActivity() {
    lateinit var db: FaskesDatabase
    lateinit var faskesBookmark: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        db = Room.databaseBuilder(applicationContext, FaskesDatabase::class.java, "faskes-db").build()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)
        faskesBookmark = findViewById(R.id.faskes_bookmark)
        GlobalScope.launch {
            //memanggil function di dalam coroutine
            //db.clearAllTables()
            showFaskes()
        }
        // val namaTV textView = findViewById(R.id.nama_faskes);
        /*
        intent.putExtra("kode", myList[position].kode)
        intent.putExtra("alamat", myList[position].alamat)
        intent.putExtra("telp", myList[position].telp)
        intent.putExtra("jenis_faskes", myList[position].jenis_faskes)
        intent.putExtra("status", myList[position].status) */
    }
    fun showFaskes() {
        val faskes: List<Faskes> = db.faskesDao().getAllFaskes()
        var displayText = ""
        for (faskes in faskes) {
            displayText += "${faskes.nama}\n"
        }
        faskesBookmark.text = displayText;
    }
}
