package com.ott.ottapplication.models

import com.google.gson.annotations.SerializedName

class Movies {

    @SerializedName("name")
    lateinit var name: String

    @SerializedName("videos")
    lateinit var videos: ArrayList<Videos>

}