package com.example.app_challenge

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.android.volley.Request
import com.android.volley.Response
//import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(){
    private val TIME : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({startActivity(Intent(this, MainActivity::class.java))}, TIME)
        //val img = image.getString()
        Glide.with(applicationContext).load("https://www.empowering-project.eu/wp-content/uploads/2019/02/imagen-02_04-02_ok-1024x536.png").into(splashImage)
    }

}

