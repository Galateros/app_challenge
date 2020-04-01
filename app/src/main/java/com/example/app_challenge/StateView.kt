package com.example.app_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class StateView : AppCompatActivity() {
    private lateinit var qualityAdapter:QualityStateRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        val country = intent.getSerializableExtra("country") as? String
        val state = intent.getSerializableExtra("state") as? String
        //val city = intent.getSerializableExtra("city") as? String
        //val dude = intent.getSerializableExtra("country") as? String


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_view)
        setRecyclerView()
        AirStateQualityVolley("https://api.airvisual.com/v2/cities?state=$state&country=$country&key=b1e64074-3f61-41c6-ab37-c02b11919b7a",this,qualityAdapter).callQualityAPI()
        qualityAdapter.setCountry(country)
        qualityAdapter.setState(state)
    }
    private fun setRecyclerView(){
        recycler_view_muc.apply {
            layoutManager = LinearLayoutManager(this@StateView)
            qualityAdapter = QualityStateRecycleAdapter()
            adapter = qualityAdapter
        }
    }
}
