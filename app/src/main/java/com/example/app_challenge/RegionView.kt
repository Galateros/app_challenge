package com.example.app_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class RegionView : AppCompatActivity() {
    private lateinit var qualityAdapter:QualityRegionRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        val country = intent.getSerializableExtra("country") as? String

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_region_view)
        setRecyclerView()
        println(country)
        qualityAdapter.setCountry(country)
        AirRegionQualityVolley("https://api.airvisual.com/v2/states?country=$country&key=b1e64074-3f61-41c6-ab37-c02b11919b7a",this,qualityAdapter).callQualityAPI()
        //qualityAdapter.setData(toSend)
    }
    private fun setRecyclerView(){
        recycler_view_muc.apply {
            layoutManager = LinearLayoutManager(this@RegionView)
            qualityAdapter = QualityRegionRecycleAdapter()
            adapter = qualityAdapter
        }
    }
}
