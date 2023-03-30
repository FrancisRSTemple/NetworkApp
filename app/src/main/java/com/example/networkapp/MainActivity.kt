package com.example.networkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //the IO dispatcher is used for input/output operations
        //e.g. network access
        CoroutineScope(Dispatchers.IO).launch {
            val url = URL("https://wikipedia.com")

            //typically, for websites which display mainly text data
            //we want to buffer the text (read one line at a time)
            url.openStream().bufferedReader().readLine().run {
                Log.d("Response", this)
            }
        }

    }
}