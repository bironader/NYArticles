package com.example.nyarticles.framework.datasource.remote.implementation

import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.framework.datasource.remote.ArticlesListApi
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import com.example.nyarticles.framework.utils.toDomainModel
import javax.inject.Inject


class ArticleListDataSourceImpl @Inject constructor(private val articlesListApi: ArticlesListApi) :
    ArticlesListDataSource {
    override suspend fun getArticles(): List<ArticleDomainModel> {
        return articlesListApi.getArticles().items.map { it.toDomainModel() }
    }
}