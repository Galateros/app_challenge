package com.example.app_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_current_location_view.*

class CurrentLocationView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_location_view)
        AirCurrentQualityVolley("https://api.airvisual.com/v2/nearest_city?key=b1e64074-3f61-41c6-ab37-c02b11919b7a",this,ciudad,estado,calidad,resultado).callQualityAPI()
    }
}
