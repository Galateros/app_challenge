package com.example.app_challenge


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
        var json = "{\n" +
                "  \"status\": \"success\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"country\": \"Andorra\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"country\": \"Argentina\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"country\": \"Australia\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"country\": \"Austria\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"country\": \"Bahamas\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"country\": \"Bahrain\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"country\": \"Bangladesh\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"country\": \"Belgium\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"country\": \"Bosnia Herzegovina\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"country\": \"Brazil\"\n" +
                "    }]}"
        var toArray = JSONObject(json)
        var toSend = toArray.getJSONArray("data")


            //val json = JSONObject(URL("https://api.airvisual.com/v2/countries?key={{key}}").readText()).getJSONArray("data")
            //println(json)
            // val image = personaje.getJSONObject("thumbnail")


        println(toSend)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
        qualityAdapter.setData(toSend)




        //println(apiUrl)


        //val apiResponse = URL("yourUrl").readText()
        val button = findViewById<Button>(R.id.button)
        button?.setOnClickListener()
        {
            Toast.makeText(this@MainActivity,
                "WARK", Toast.LENGTH_LONG).show() }


    Toast.makeText(this, "Climate Change", Toast.LENGTH_LONG).show()
        Log.i("climatechange","CC Loading")

    }

    private fun getData() : JSONArray{
        var toResponse:JSONArray = JSONArray()
        Executors.newSingleThreadExecutor().execute({
            val json = URL("https://api.airvisual.com/v2/countries?key={KEY}").readText()
            //println(json)
            var obj = JSONObject(json)
            var array = obj.getJSONArray("data")
            toResponse = array

            // val image = personaje.getJSONObject("thumbnail")

        })
        return toResponse
    }
    private fun setRecyclerView(){
        recycler_view_muc.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            qualityAdapter = QualityRecycleAdapter()
            adapter = qualityAdapter
        }
    }

}
