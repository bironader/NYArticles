package com.example.nyarticles.framework.datasource.remote.responses


import com.google.gson.annotations.SerializedName

data class Fault(
    @SerializedName("detail")
    val detail: Detail = Detail(),
    @SerializedName("faultstring")
    val faultstring: String = ""
)