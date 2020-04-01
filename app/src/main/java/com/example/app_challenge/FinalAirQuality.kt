package com.example.app_challenge

import android.widget.TextView
import org.json.JSONArray

class FinalAirQuality (var airq:TextView){
    var q:String = ""
   fun setQuality(array: JSONArray){

       airq.text = array.getJSONObject(0).getString("aqius")



    }
    fun getQuality():String{
        return q
    }
}