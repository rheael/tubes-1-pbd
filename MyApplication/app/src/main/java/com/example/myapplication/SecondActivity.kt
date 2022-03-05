package com.example.myapplication

/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}*/

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.MyAdapterFaskes
import com.example.myapplication.model.Detail
import com.example.myapplication.model.Faskes
import com.example.myapplication.repository.Repository
import org.chromium.base.Log
import java.util.*
import kotlin.collections.*

class SecondActivity : AppCompatActivity() {
    private lateinit var viewModel: SecondViewModel;
    private val myAdapterFaskes by lazy { MyAdapterFaskes() }
    private var longitude = -6.1351855
    private var latitude = 11.0323457
    private var locationManager : LocationManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // ngambil lokasi pengguna
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),1)
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            val location: Location = locationManager?.getLastKnownLocation(LocationManager.GPS_PROVIDER)!!
            longitude = location.longitude
            latitude = location.latitude
        }

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
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            add<FaskesFragment>(R.id.fragmentFaskes)
                        }
                        // val fr = getSupportFragmentManager().findFragmentById(R.id.fragmentFaskes);
                        // val frRecyclerView = fr.getRecyclerView();
                        val recyclerView: RecyclerView = findViewById(R.id.recyclerview_fragment);
                        setupRecyclerView(recyclerView);
                        viewModel.getFaskes(provinceSelected, citySelected);

                        viewModel.myFaskesResults.observe(this@SecondActivity, Observer { response ->
                            // myAdapterFaskes.setData(response.data);
                            val faskes = response.data
                            Log.d("faskes", faskes.toString())
                            if (response.data.count() > 0) {
                                var distanceMap: HashMap<Faskes, Double> = hashMapOf()

                                for (i in 0 until response.data.count()) {
                                    Log.d("Response", response.data[i].nama);
                                    // val distance: Double = 0.0
                                    // haversine(originLat: Double, destinationLat: Double, originLong: Double, destinationLong: Double): Double
                                    val distance = haversine(
                                        latitude,
                                        response.data[i].latitude.toDouble(),
                                        longitude,
                                        response.data[i].longitude.toDouble()
                                    )
                                    distanceMap.put(response.data[i], distance)
                                    //Log.d("Response", response.data[i].latitude);
                                    //Log.d("Response", response.data[i].longitude);
                                    //faskes[i].add()
                                }
                                val distanceMap2 =
                                    distanceMap.toList().sortedBy { (_, value) -> value }
                                        .toMap() as MutableMap<Faskes, Double>
                                // list faskes yg ditampilin
                                val faskesSorted = MutableList<Faskes>(5) {
                                    Faskes(0,
                                        "",
                                        "",
                                        "",
                                        "",
                                        "",
                                        "",
                                        "",
                                        "",
                                        "",
                                        "",
                                        "",
                                        List<Detail>(0)
                                        { Detail(0, "", "", 0, 0, 0, 0, 0, 0, 0, 0, "") },
                                        ""
                                    )
                                };
                                // val accessAllowed: let = if (age > 18) true else false
                                val max =
                                    if (response.data.count() >= 5) 5 else response.data.count()
                                for (i in 0 until max) {
                                    faskesSorted[i] = distanceMap2.keys.toList()[i]
                                }
                                val faskesToShow = faskesSorted.toList()
                                myAdapterFaskes.setData(faskesToShow);
                                // distanceMap.toSortedMap()
                            }
                        })
                    }
                }

            }
        }
    }
    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = myAdapterFaskes
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    private fun haversine(originLat: Double, destinationLat: Double, originLong: Double, destinationLong: Double): Double {
        val earthRadiusKm: Double = 6372.8
        val dLat = Math.toRadians(originLat - destinationLat);
        val dLon = Math.toRadians(originLong - destinationLong);
        val originLatRad = Math.toRadians(originLat);
        val destinationLatRad = Math.toRadians(destinationLat);

        val a = Math.pow(Math.sin(dLat / 2), 2.toDouble()) + Math.pow(Math.sin(dLon / 2), 2.toDouble()) * Math.cos(originLatRad) * Math.cos(destinationLatRad);
        val c = 2 * Math.asin(Math.sqrt(a));
        return earthRadiusKm * c;
    }
}