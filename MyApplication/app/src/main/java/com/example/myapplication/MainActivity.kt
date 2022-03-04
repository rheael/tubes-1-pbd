package com.example.myapplication

/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}*/

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.MyAdapter
import com.example.myapplication.repository.Repository


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        setupRecyclerView(recyclerView);
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getResults()
        viewModel.myResponse.observe(this, Observer {
            response ->  myAdapter.setData(response.results);
            //Log.d("Response", response.results.toString());
            /* Log.d("Response", response.success)
            Log.d("Response", response.message)
            Log.d("Response", response.count_total.toString())*/
            /* for(i in 0 until response.results.count()) {
                //Log.d("Response", response.results[i].title)
                //Toast.makeText(this, response.results[i].title, Toast.LENGTH_LONG).show()
            }*/
        })
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun goToActivity2(view: View?) {
        val intent = Intent(this, SecondActivity::class.java);
        startActivity(intent);
    }

    fun goToBookmark(view: View?) {
        val intent = Intent(this, ListBookmarkActivity::class.java);
        startActivity(intent);
    }

    /*
    lateinit var db: BookDatabase
    lateinit var tvDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inisialisasi TextView
        tvDisplay = findViewById(R.id.tv_display)

        //inisialisasi Database
        db = Room.databaseBuilder(applicationContext, BookDatabase::class.java, "book-db").build()

        //menggunakan coroutine
        GlobalScope.launch {
            //memanggil function di dalam coroutine
            initData()
            diplayData()
        }
    }

    private fun diplayData() {
        val books: List<Book> = db.bookDao().getAllBooks()
        var displayText = ""
        for (book in books) {
            displayText += "${book.id} | ${book.title} | ${book.authorName} | Hal : ${book.totalPages}\n"
        }
        tvDisplay.text = displayText
    }

    private fun initData() {
        val book1 = Book("Ada Apa dengan Hujan", "Andre Senja", 30)
        val book2 = Book("Malam Setelah Sore", "Andi Bisa", 40)
        val book3 = Book("Pecahkan Mentari", "Dera", 20)
        //insert data ke database
        db.bookDao().insert(book1,book2,book3)
    } */
}
