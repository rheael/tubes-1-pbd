package com.example.myapplication

/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}*/

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.repository.Repository
import org.chromium.base.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.MyAdapter
import com.example.myapplication.model.Province

class SecondActivity : AppCompatActivity() {
    private lateinit var viewModel: SecondViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val spinner: Spinner = findViewById(R.id.spinner1)
        val repository = Repository()
        val viewModelFactory = SecondViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)
        //viewModel.getResults("JAWA BARAT", "KOTA BANDUNG")
        //val province = List<String>()
        /* viewModel.myProvinceResults.observe(this, Observer {
                response -> Log.d(response.results.toString())
        } */
        val province = mutableListOf<String>();
        viewModel.getProvince();
        viewModel.myProvinceResults.observe(this, Observer {
                /*response ->  Log.d("Response", response.results.key)
                Log.d("Response", response.results.value); */
            response ->
            for(i in 0 until response.results.count()) {
                Log.d("Response", response.results[i].key)
                province.add(response.results[i].key);
            }
        })
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, province)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        aa.notifyDataSetChanged();
    }
}