package com.example.nyarticles.business.entites


import com.google.gson.annotations.SerializedName

data class Fault(
    @SerializedName("detail")
    val detail: Detail = Detail(),
    @SerializedName("faultstring")
    val faultstring: String = ""
)