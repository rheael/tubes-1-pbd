package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if (savedInstanceState ==null){
            replaceFragment(NewsFragment())
        }

        var button: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        button.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_article -> {
                    replaceFragment(NewsFragment())
                    true
                }
                R.id.nav_location -> {
                    replaceFragment(LokasiFragment())
                    true
                }
                else -> false
            }
        }
    }

    fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameContent,fragment)
        transaction.commit()
    }
}