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
        spinner.setSelected(false);
        spinner.setSelection(0,true);

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var provinceSelected = "JAWA BARAT"; // default value
                if (spinner.selectedItem!=null) {
                    provinceSelected = (spinner.selectedItem.toString()).uppercase();
                }
                Log.d("Province",provinceSelected);
                val spinner2: Spinner = findViewById(R.id.spinner2);
                viewModel.getCity(provinceSelected);
                val city = Array<String>(30) {""};
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
                spinner2.setSelected(false);
                spinner2.setSelection(0,true);
                aa2.notifyDataSetChanged();
                spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        var citySelected = "KOTA BANDUNG";
                        if (spinner2.selectedItem!=null) {
                            citySelected = (spinner2.selectedItem.toString()).uppercase();
                        }
                        Log.d("Province",citySelected);
                        viewModel.getFaskes(provinceSelected, citySelected);
                        viewModel.myFaskesResults.observe(this@SecondActivity, Observer {
                                response ->
                            for(i in 0 until response.data.count()) {
                                Log.d("Response", response.data[i].nama)
                            }
                        })
                    }
                }
//spinner2.setSelected(false);
//spinner2.setSelection(0,true);
                /*
spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var citySelected = "KOTA BANDUNG" // default value
        var init = 0;
        //Log.d("Response", citySelected);
        if (init!=0) {
            citySelected = (spinner2.selectedItem.toString()).uppercase();
            //viewModel.getFaskes(provinceSelected.uppercase(), citySelected.uppercase());
            //viewModel.getFaskes("JAWA BARAT", "KOTA BANDUNG");
            //viewModel.getFaskes(provinceSelected, citySelected);
            /*viewModel.myFaskesResults.observe(
                this@SecondActivity,
                Observer { response ->
                    for (i in 0 until response.data.count()) {
                        Log.d("Response", response.data[i].nama)
                        //city[i] = response.results[i].key;
                    }
                })
            Log.d("Response", provinceSelected);
            Log.d("Response", citySelected);*/
        }
        else {
            init += 1;
        }
    }
}*/
            }
        }
    }
}
