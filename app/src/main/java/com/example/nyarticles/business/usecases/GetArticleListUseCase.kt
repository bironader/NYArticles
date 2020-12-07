package com.example.nyarticles.business.usecases

import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Result
import com.example.nyarticles.business.repositories.ArticleListRepo
import javax.inject.Inject


class GetArticleListUseCase @Inject constructor(private val articleListRepo: ArticleListRepo) {

    suspend fun getArtcilesFromRepo(
        onSuccess: (Result<Article>) -> Unit,
        onFailed: (Throwable) -> Unit
    ) =
        articleListRepo.fetchArticles(onSuccess, onFailed)


}