package com.example.nyarticles.business.usecases.impl

import com.example.nyarticles.business.repositories.abstraction.ArticleListRepo
import com.example.nyarticles.business.repositories.impl.ArticleListRepoImpl
import com.example.nyarticles.business.usecases.abstraction.GetArtcileListUseCase
import javax.inject.Inject


class GetArticleListUseCaseImpl @Inject constructor(private val articleListRepoImpl: ArticleListRepo) :
    GetArtcileListUseCase {
    override suspend fun getArtciles() =
        articleListRepoImpl.fetchArticles()


}