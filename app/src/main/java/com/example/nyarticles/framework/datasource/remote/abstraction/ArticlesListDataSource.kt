package com.example.nyarticles.framework.datasource.remote.abstraction

import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.framework.datasource.remote.responses.Article
import retrofit2.Response

interface ArticlesListDataSource {

    suspend fun getArticles(): List<ArticleDomainModel>
}