package com.example.app_challenge

import android.content.Context
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import org.w3c.dom.Text

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
class AirRegionQualityVolley (val url:String, val contexto: Context, val qrAdapter:QualityRegionRecycleAdapter ) {

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
class AirStateQualityVolley (val url:String, val contexto: Context, val qrAdapter:QualityStateRecycleAdapter ) {

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
class AirFinalQualityVolley (val url:String, val contexto: Context, var qrAdapter:TextView ,var resultado:TextView) {

    val queue = Volley.newRequestQueue(contexto)
    fun callQualityAPI(){
        val data = JSONArray()
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener<JSONObject> { response ->
                val data = response.getJSONObject("data").getJSONObject("current").getJSONObject("pollution").getString("aqius")

               // println(data)

                qrAdapter.text = data
                val airq = data.toInt()
                if(airq <= 50){
                    resultado.text = "Calidad del Aire Exelente"
                }else if( airq >50 && airq <=100){
                    resultado.text = "Buena Calidad del Aire"
                }else if(airq > 100 && airq <=150){
                    resultado.text = "Ligeramente Contaminado"
                }else if(airq > 150 && airq<=200){
                    resultado.text = "Medianamente Contaminado"
                }else if(airq > 200 && airq<=300){
                    resultado.text = "Altamente Contaminado"
                }else{
                    resultado.text = "No Salga Joven"
                }

            },
            Response.ErrorListener {
                Log.e("Volley Error", it.toString())
                Toast.makeText(contexto, "That didn't work!" + it.toString(), Toast.LENGTH_SHORT).show()
            })

        queue.add(request)
    }
}
class AirCurrentQualityVolley (val url:String, val contexto: Context,var ciudad:TextView,var state:TextView, var qrAdapter:TextView ,var resultado:TextView) {

    val queue = Volley.newRequestQueue(contexto)
    fun callQualityAPI(){
        val data = JSONArray()
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener<JSONObject> { response ->
                val data = response.getJSONObject("data")

                // println(data)
                ciudad.text = data.getString("city")
                state.text = data.getString("state")
                qrAdapter.text = data.getJSONObject("current").getJSONObject("pollution").getString("aqius")
                val airq = data.getJSONObject("current").getJSONObject("pollution").getString("aqius").toInt()
                if(airq <= 50){
                    resultado.text = "Calidad del Aire Exelente"
                }else if( airq >50 && airq <=100){
                    resultado.text = "Buena Calidad del Aire"
                }else if(airq > 100 && airq <=150){
                    resultado.text = "Ligeramente Contaminado"
                }else if(airq > 150 && airq<=200){
                    resultado.text = "Medianamente Contaminado"
                }else if(airq > 200 && airq<=300){
                    resultado.text = "Altamente Contaminado"
                }else{
                    resultado.text = "No Salga Joven"
                }

            },
            Response.ErrorListener {
                Log.e("Volley Error", it.toString())
                Toast.makeText(contexto, "That didn't work!" + it.toString(), Toast.LENGTH_SHORT).show()
            })

        queue.add(request)
    }
}