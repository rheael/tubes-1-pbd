package com.example.myapplication

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        val url: String = intent.getStringExtra("url").toString()
        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.loadUrl(url);

    }
}