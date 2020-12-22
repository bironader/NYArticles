package com.example.nyarticles.framework.datasource.remote

import com.example.nyarticles.BuildConfig
import com.example.nyarticles.Constants.API_KEY
import com.example.nyarticles.Constants.PERIOD
import com.example.nyarticles.Constants.SECTION
import com.example.nyarticles.Constants.URL_PATH
import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticlesListApi {


    @GET(URL_PATH)
    suspend fun getArticles(
        @Path(SECTION) section: String? = "viewed", @Path(PERIOD) period: Int? = 7, @Query(
            API_KEY
        ) apiKey: String = BuildConfig.API_KEY
    ): Response<Result<Article>>

}