package com.example.nyarticles.framework.datasource.remote.abstraction

import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Result

interface ArticlesListDataSource {

    suspend fun getArticles(): Result<Article>
}