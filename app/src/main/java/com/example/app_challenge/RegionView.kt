package com.example.app_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class RegionView : AppCompatActivity() {
    private lateinit var qualityAdapter:QualityRegionRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        //val dude = intent.getSerializableExtra("country") as? String
        var json ="{\n" +
                "  \"status\": \"success\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"state\": \"AR\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"Alabama\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"Alaska\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"Arizona\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"Arkansas\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"California\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"Colorado\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"Connecticut\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"Delaware\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"District Of Columbia\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"Florida\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"Georgia\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"state\": \"Hawaii\"\n" +
                "    }]}"
        var toArray = JSONObject(json)
        var toSend = toArray.getJSONArray("data")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_region_view)
        setRecyclerView()
        qualityAdapter.setData(toSend)
    }
    private fun setRecyclerView(){
        recycler_view_muc.apply {
            layoutManager = LinearLayoutManager(this@RegionView)
            qualityAdapter = QualityRegionRecycleAdapter()
            adapter = qualityAdapter
        }
    }
}
