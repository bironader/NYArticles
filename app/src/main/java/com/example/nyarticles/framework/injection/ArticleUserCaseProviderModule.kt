package com.example.nyarticles.framework.injection

import com.example.nyarticles.business.repositories.ArticleListRepo
import com.example.nyarticles.business.usecases.GetArticleListUseCase
import com.example.nyarticles.framework.datasource.remote.ArticlesListApi
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import com.example.nyarticles.framework.datasource.remote.implementation.ArticleListImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@InstallIn(ApplicationComponent::class)
@Module
class ArticleUserCaseProviderModule {


    @Provides
    fun provideGetArticleListUseCase(articleListRepo: ArticleListRepo): GetArticleListUseCase =
        GetArticleListUseCase(articleListRepo)
}