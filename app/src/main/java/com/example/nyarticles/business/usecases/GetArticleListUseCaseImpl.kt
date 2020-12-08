package com.example.nyarticles.business.usecases

import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Result
import com.example.nyarticles.business.repositories.ArticleListRepo
import javax.inject.Inject


class GetArticleListUseCaseImpl @Inject constructor(private val articleListRepo: ArticleListRepo) :
    GetArtcileListUseCase {


    override suspend fun getArtcilesFromRepo(
        onSuccess: (Result<Article>) -> Unit,
        onFailed: (Throwable) -> Unit
    ) =
        articleListRepo.fetchArticles(onSuccess, onFailed)


}