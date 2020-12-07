package com.example.nyarticles.business.entites


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("abstract")
    val `abstract`: String = "",
    @SerializedName("adx_keywords")
    val adxKeywords: String = "",
    @SerializedName("asset_id")
    val assetId: Long = 0,
    @SerializedName("byline")
    val byline: String = "",
    @SerializedName("column")
    val column: Any = Any(),
    @SerializedName("eta_id")
    val etaId: Int = 0,
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("media")
    val media: List<Media> = listOf(),
    @SerializedName("nytdsection")
    val nytdsection: String = "",
    @SerializedName("published_date")
    val publishedDate: String = "",
    @SerializedName("section")
    val section: String = "",
    @SerializedName("source")
    val source: String = "",
    @SerializedName("subsection")
    val subsection: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("updated")
    val updated: String = "",
    @SerializedName("uri")
    val uri: String = "",
    @SerializedName("url")
    val url: String = ""
)