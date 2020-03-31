package com.example.app_challenge

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_quality_recycle_adapter.view.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL
import java.util.concurrent.Executors

//import kotlinx.android.synthetic.main.mcu_dude_layout.view.*
//QualityRecycleAdapter
class QualityStateRecycleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var countries:JSONArray= JSONArray()
    private var toSendCountry:String? = ""
    private var toSendState:String? = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return AirStateQualityViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_quality_state_recycle_adapter, parent, false)
        )
    }

    override fun getItemCount(): Int {

        return countries.length()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is AirStateQualityViewHolder -> {
                holder.bind(countries.getJSONObject(position))
                holder.itemView.setOnClickListener{
                    val contexto = it.context
                    val intent = Intent(contexto, FinalView::class.java)
                    intent.putExtra("country",toSendCountry)
                    intent.putExtra("state",toSendState)
                    intent.putExtra("city",countries.getJSONObject(position).getString("city"))
                    contexto.startActivity(intent)
                    Toast.makeText(contexto, "INSIDE DUDE", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    fun setCountry(x: String?){
        toSendCountry = x
    }
    fun setState(x: String?){
        toSendState = x
    }
    fun setData(c: JSONArray){
        countries = c
        notifyDataSetChanged()
        //println("Countries 1:"+countries)
    }
}
class AirStateQualityViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imageDude = itemView.imageView
    val name = itemView.name_alias
    val notes = itemView.notes

    fun bind(country: JSONObject) {

        name.text = country.getString("city")
        notes.text = "WARK"

    }

}