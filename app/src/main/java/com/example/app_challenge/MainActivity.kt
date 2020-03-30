package com.example.app_challenge


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val apiUrl = URL("api.airvisual.com/v2/nearest_city?key=b1e64074-3f61-41c6-ab37-c02b11919b7a")

        with(apiUrl.openConnection() as HttpURLConnection){
            requestMethod= "GET"
            println("$url")
            println("$responseCode")

            BufferedReader(InputStreamReader(inputStream)).use{
                val response = StringBuffer()

                println("Response : $response")
            }
        }

        Toast.makeText(this, "Climate Change", Toast.LENGTH_LONG).show()
        Log.i("climatechange","CC Loading")

    }

}
