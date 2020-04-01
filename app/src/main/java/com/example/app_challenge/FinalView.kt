package com.example.app_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_final_view.*
import org.json.JSONArray

class FinalView : AppCompatActivity() {
    //
    var finalResult = JSONArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        val country = intent.getSerializableExtra("country") as? String
        val state = intent.getSerializableExtra("state") as? String
        val city = intent.getSerializableExtra("city") as? String

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_view)
        setData(country,state,city)
        calidad.text = "holi"
        AirFinalQualityVolley("https://api.airvisual.com/v2/city?city=$city&state=$state&country=$country&key=b1e64074-3f61-41c6-ab37-c02b11919b7a",this,calidad,resultado).callQualityAPI()
        //AirFinalQualityVolley("https://api.airvisual.com/v2/city?city=$city&state=$state&country=$country&key=b1e64074-3f61-41c6-ab37-c02b11919b7a",this, this).callQualityAPI()
    }
    fun setData(country:String?,state:String?,city:String?){
        ciudad.text = city
        estado.text = state

    }

}
