package com.example.app_challenge

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class AirQualityVolley (val url:String, val contexto: Context, val qrAdapter:QualityRecycleAdapter ) {

    val queue = Volley.newRequestQueue(contexto)
    fun callQualityAPI(){
        val data = JSONArray()
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener<JSONObject> { response ->
                val data = response.getJSONArray("data")



                qrAdapter.setData(data)
            },
            Response.ErrorListener {
                Log.e("Volley Error", it.toString())
                Toast.makeText(contexto, "That didn't work!" + it.toString(), Toast.LENGTH_SHORT).show()
            })

        queue.add(request)
    }
}