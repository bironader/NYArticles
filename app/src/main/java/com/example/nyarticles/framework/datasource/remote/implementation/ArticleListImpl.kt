package com.example.nyarticles.framework.datasource.remote.implementation

import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.framework.datasource.remote.ArticlesListApi
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import javax.inject.Inject


class ArticleListImpl @Inject constructor(private val articlesListApi: ArticlesListApi) :
    ArticlesListDataSource {
    override suspend fun getArticles() = articlesListApi.getArticles()
}