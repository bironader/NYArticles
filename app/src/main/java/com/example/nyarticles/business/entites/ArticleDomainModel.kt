package com.example.nyarticles.business.entites

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleDomainModel(
    var title: String,
    var image: String? = "",
    var byline: String,
    var publishedDate: String,
    var abstract: String
) : Parcelable
