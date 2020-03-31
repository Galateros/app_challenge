package com.example.app_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONObject
import java.net.URL
import java.util.concurrent.Executors

class AirrQualityActivity : AppCompatActivity() {

    var response = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_airr_quality)
    }

    fun qualityTextLocation(){

    }
    fun qualityCurrentLocation(){
        Executors.newSingleThreadExecutor().execute({
            val json = URL("https://api.airvisual.com/v2/nearest_city?key=b1e64074-3f61-41c6-ab37-c02b11919b7a").readText()
            println(json)
            var obj = JSONObject(json)
            //response = json.getString("aqius")
            obj = JSONObject(obj.getString("data"))
            obj = JSONObject(obj.getString("current"))
            obj = JSONObject(obj.getString("pollution"))
            println(obj.getString("aqius"))
            response = obj.getString("aqius")

            // val image = personaje.getJSONObject("thumbnail")
        })
    }

}
