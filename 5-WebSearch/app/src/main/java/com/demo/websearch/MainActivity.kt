package com.demo.websearch

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val webviewClint=WebViewClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.webViewClient=webviewClint
        webView.loadUrl("www.google.kz")


        button_search.setOnClickListener {  val searchText = editText_search.text.toString()
            search(searchText)}

        val ime = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        ime.hideSoftInputFromWindow(button_search.windowToken, 0)

        editText_search.setOnEditorActionListener{ view, actionId, event ->
            println("did enter EditTextHandler")
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                val searchText = editText_search.text.toString()
                search(searchText)
            }

            val ime = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            ime.hideSoftInputFromWindow(button_search.windowToken, 0)

        }}
        private fun search(text:String){
            if (text.isEmpty()) {
                val toast = Toast.makeText(this,"Input message",Toast.LENGTH_SHORT).show()

            } else {
                webView.loadUrl("https://www.google.com.tw/search?q=$text")
            }
        }

    }

