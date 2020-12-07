package com.example.nyarticles.framework.injection

import com.example.nyarticles.business.repositories.ArticleListRepo
import com.example.nyarticles.framework.datasource.remote.ArticlesListApi
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import com.example.nyarticles.framework.datasource.remote.implementation.ArticleListImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit


@InstallIn(ApplicationComponent::class)
@Module
class ArticleListApiProviderModule {


    @Provides
    fun provideArticlesListApi(retrofit: Retrofit): ArticlesListApi =
        retrofit.create(ArticlesListApi::class.java)

    @Provides
    fun provideArticlesListDataSource(articlesListApi: ArticlesListApi): ArticlesListDataSource =
        ArticleListImpl(articlesListApi)


    @Provides
    fun provideArticlesListRepo(dataSource: ArticlesListDataSource): ArticleListRepo =
        ArticleListRepo(dataSource)

}