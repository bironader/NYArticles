package com.example.nyarticles.business.repositories.abstraction

import com.example.nyarticles.business.entites.ArticleDomainModel
import kotlinx.coroutines.flow.Flow

interface ArticleListRepo {

    suspend fun fetchArticles(): Flow<List<ArticleDomainModel>>
}