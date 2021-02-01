package com.example.nyarticles.framework.datasource.remote.responses

import com.google.gson.annotations.SerializedName

data class Result<T>(
    @SerializedName("results")
    val items: List<T>
)
