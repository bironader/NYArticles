package com.example.nyarticles.business.entites

import com.google.gson.annotations.SerializedName

data class Result<T>(
    @SerializedName("results")
    val items: List<T>?
)
