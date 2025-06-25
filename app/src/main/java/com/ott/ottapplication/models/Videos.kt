package com.ott.ottapplication.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Videos (
    @SerializedName("description")
    val description: String,
    @SerializedName("sources")
    val sources: ArrayList<String>,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("thumb")
    val thumb: String,
    @SerializedName("title")
    val title: String,
) : Serializable
