package com.example.nyarticles.business.repositories.impl

import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.business.repositories.abstraction.ArticleListRepo
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArticleListRepoImpl @Inject constructor(private val articlesListDataSource: ArticlesListDataSource) :
    ArticleListRepo {
    override suspend fun fetchArticles() = flow {
        emit(articlesListDataSource.getArticles())
    }


}