package com.example.app_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class StateView : AppCompatActivity() {
    private lateinit var qualityAdapter:QualityStateRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        //val dude = intent.getSerializableExtra("country") as? String
        var json ="{\n" +
                "  \"status\": \"success\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"city\": \"Addison\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"city\": \"Albany\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"city\": \"Buffalo\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"city\": \"Carmel\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"city\": \"Dunkirk\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"city\": \"East Syracuse\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"city\": \"Farmingdale\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"city\": \"Holtsville\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"city\": \"Ithaca\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"city\": \"La Fargeville\"\n" +
                "    }]}"
        var toArray = JSONObject(json)
        var toSend = toArray.getJSONArray("data")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_view)
        setRecyclerView()
        qualityAdapter.setData(toSend)
    }
    private fun setRecyclerView(){
        recycler_view_muc.apply {
            layoutManager = LinearLayoutManager(this@StateView)
            qualityAdapter = QualityStateRecycleAdapter()
            adapter = qualityAdapter
        }
    }
}
