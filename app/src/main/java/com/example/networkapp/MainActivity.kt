package com.example.networkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textDisplay = findViewById<TextView>(R.id.textDisplay)

        Volley.newRequestQueue(this).add(
                StringRequest(Request.Method.GET, "https://wikipedia.com",{
                textDisplay.text = it
            },{
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            })
        )

        //the IO dispatcher is used for input/output operations
        //e.g. network access
        /*CoroutineScope(Dispatchers.IO).launch {
            val url = URL("https://wikipedia.com")

            //typically, for websites which display mainly text data
            //we want to buffer the text (read one line at a time)
            val response = url.openStream().bufferedReader().run {
                val strBuilder = StringBuilder()

                while(readLine().let {
                        strBuilder.append("$it\n")
                        it != null
                    });
                strBuilder.toString()
            }
            Log.d("Response", response)
            withContext(Dispatchers.Main){
                textDisplay.text = response
            }
        }
        */
    }
}