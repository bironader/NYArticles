package com.example.nyarticles.framework.datasource.remote.responses


import com.google.gson.annotations.SerializedName

data class Detail(
    @SerializedName("errorcode")
    val errorcode: String = ""
)