package com.example.nyarticles.business.entites

import com.google.gson.annotations.SerializedName

data class Error(@SerializedName("fault") val fault: Fault)
