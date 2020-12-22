package com.example.nyarticles.framework.datasource.remote.abstraction

import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Result
import retrofit2.Response

interface ArticlesListDataSource {

    suspend fun getArticles(): Response<Result<Article>>
}