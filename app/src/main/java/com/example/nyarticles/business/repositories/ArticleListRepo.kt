package com.example.nyarticles.business.repositories

import com.example.nyarticles.business.entites.ApiResponseWraper
import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Result
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

class ArticleListRepo @Inject constructor(private val articlesListDataSource: ArticlesListDataSource) {

    suspend fun fetchArticles(): ApiResponseWraper<Article> {
        val responseWraper = ApiResponseWraper<Article>(null, null)
        try {
            responseWraper.result = articlesListDataSource.getArticles()

        } catch (throwable: Throwable) {
            responseWraper.throwable = throwable
        }
        return responseWraper
    }

}