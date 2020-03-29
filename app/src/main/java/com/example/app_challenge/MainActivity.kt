package com.example.app_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(this, "Climate Change", Toast.LENGTH_LONG).show()
        Log.i("climatechange","CC Loading")

    }

}
