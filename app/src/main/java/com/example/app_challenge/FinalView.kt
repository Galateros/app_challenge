package com.example.app_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONArray

class FinalView : AppCompatActivity() {
    //
    //var finalResult = JSONArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        val country = intent.getSerializableExtra("country") as? String
        val state = intent.getSerializableExtra("state") as? String
        val city = intent.getSerializableExtra("city") as? String

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_view)
        //finalResult = AirFinalQualityVolley("https://api.airvisual.com/v2/city?city=$city&state=$state&country=$country&key=b1e64074-3f61-41c6-ab37-c02b11919b7a",this, finalResult).callQualityAPI()
        //println(finalResult)
    }


}
