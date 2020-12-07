package com.example.nyarticles.business.usecases

import com.example.nyarticles.business.repositories.ArticleListRepo
import javax.inject.Inject


class GetArticleListUseCase @Inject constructor(private val articleListRepo: ArticleListRepo) {

    suspend fun getArtcilesFromRepo() = articleListRepo.fetchArticles()


}