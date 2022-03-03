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
import java.util.*
import kotlin.collections.*

class SecondActivity : AppCompatActivity() {
    private lateinit var viewModel: SecondViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val spinner: Spinner = findViewById(R.id.spinner1)
        val repository = Repository()
        val viewModelFactory = SecondViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)
        val province = Array<String>(34) {""};
        viewModel.getProvince();
        //viewModel.getCity("Gorontalo");
        viewModel.myProvinceResults.observe(this, Observer {
            response ->
            for(i in 0 until response.results.count()) {
                Log.d("Response", response.results[i].key)
                province[i] = (response.results[i].key);
            }
        })
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, province)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.adapter = aa;

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val provinceSelected = spinner.selectedItem.toString();
                Log.d("Province",provinceSelected);
                //Toast.makeText(this@SecondActivity, provinceSelected, Toast.LENGTH_LONG).show();
                val spinner2: Spinner = findViewById(R.id.spinner2);
                //viewModel.getCity(provinceSelected);
                /*val city = Array<String>(30) {""};
                viewModel.myCityResults.observe(this@SecondActivity, Observer {
                    response ->
                    for(i in 0 until response.results.count()) {
                        Log.d("Response", response.results[i].key)
                        city[i] = response.results[i].key;
                    }
                })
                val aa2 = ArrayAdapter(this@SecondActivity, android.R.layout.simple_spinner_item, city)
                aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(aa2);
                aa2.notifyDataSetChanged();*/
            }

        }
        // Coba yang kota
        /* val spinner2: Spinner = findViewById(R.id.spinner2)
        val provinceSelected = spinner.selectedItem.toString();
        viewModel.getCity(provinceSelected);
        val city = mutableListOf<String>();
        viewModel.myCityResults.observe(this, Observer {
                response ->
            for(i in 0 until response.results.count()) {
                Log.d("Response", response.results[i].key)
                city.add(response.results[i].key);
            }
        })
        val aa2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, city)
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(aa2);
        aa.notifyDataSetChanged(); */
    }
}