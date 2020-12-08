package com.example.nyarticles.injection

import com.example.nyarticles.business.repositories.ArticleListRepo
import com.example.nyarticles.business.usecases.GetArtcileListUseCase
import com.example.nyarticles.business.usecases.GetArticleListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@InstallIn(ApplicationComponent::class)
@Module
class ArticleUserCaseProviderModule {


    @Provides
    fun provideGetArticleListUseCase(articleListRepo: ArticleListRepo): GetArtcileListUseCase =
        GetArticleListUseCaseImpl(articleListRepo)
}