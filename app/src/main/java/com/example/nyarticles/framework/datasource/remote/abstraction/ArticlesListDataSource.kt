package com.example.nyarticles.framework.datasource.remote.abstraction

import com.example.nyarticles.business.entites.ArticleDomainModel

interface ArticlesListDataSource {

    suspend fun getArticles(): List<ArticleDomainModel>
}