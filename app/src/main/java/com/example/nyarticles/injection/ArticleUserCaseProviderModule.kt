package com.example.nyarticles.injection

import com.example.nyarticles.business.repositories.impl.ArticleListRepoImpl
import com.example.nyarticles.business.usecases.GetArtcileListUseCase
import com.example.nyarticles.business.usecases.GetArticleListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ArticleUserCaseProviderModule {

    @Singleton
    @Provides
    fun provideGetArticleListUseCase(articleListRepoImpl: ArticleListRepoImpl): GetArtcileListUseCase =
        GetArticleListUseCaseImpl(articleListRepoImpl)
}