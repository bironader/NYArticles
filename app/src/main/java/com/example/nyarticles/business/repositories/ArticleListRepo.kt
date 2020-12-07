package com.example.nyarticles.business.repositories

import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

class ArticleListRepo @Inject constructor(private val articlesListDataSource: ArticlesListDataSource) {

    suspend fun fetchArticles() = articlesListDataSource.getArticles()

}