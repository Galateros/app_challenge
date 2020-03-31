package com.example.app_challenge

import java.io.Serializable

class Quality (val quality: Int) : Serializable{
public var airquality:Int?=null
    init {
        airquality = quality
    }
}