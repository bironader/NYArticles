package com.example.nyarticles.framework.datasource.remote.responses

import com.google.gson.annotations.SerializedName

data class Error(@SerializedName("fault") val fault: Fault)
