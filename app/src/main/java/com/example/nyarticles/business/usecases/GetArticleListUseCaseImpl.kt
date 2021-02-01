package com.example.nyarticles.business.usecases

import com.example.nyarticles.business.repositories.impl.ArticleListRepoImpl
import javax.inject.Inject


class GetArticleListUseCaseImpl @Inject constructor(private val articleListRepoImpl: ArticleListRepoImpl) :
    GetArtcileListUseCase {

    override suspend fun getArtcilesFromRepo() = articleListRepoImpl.fetchArticles()

}