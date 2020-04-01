package com.example.app_challenge


import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.net.URL
import java.util.concurrent.Executors
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.InputStream
import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp


class MainActivity : AppCompatActivity() {
    private lateinit var qualityAdapter:QualityRecycleAdapter

    var response:JSONArray = JSONArray();
    //val apiUrl = URL("https://api.airvisual.com/v2/nearest_city?key=b1e64074-3f61-41c6-ab37-c02b11919b7a").readText()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
        AirQualityVolley("https://api.airvisual.com/v2/countries?key=b1e64074-3f61-41c6-ab37-c02b11919b7a",this,qualityAdapter).callQualityAPI()

        val button = findViewById<Button>(R.id.button)
        button?.setOnClickListener()
        {
            val intent = Intent(this, CurrentLocationView::class.java)
            this.startActivity(intent)
        }
    Toast.makeText(this, "Climate Change", Toast.LENGTH_LONG).show()
        Log.i("climatechange","CC Loading")

    }


    private fun setRecyclerView(){
        recycler_view_muc.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            qualityAdapter = QualityRecycleAdapter()
            adapter = qualityAdapter
        }
    }

}
