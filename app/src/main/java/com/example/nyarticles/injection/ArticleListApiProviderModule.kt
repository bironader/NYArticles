package com.example.nyarticles.injection

import com.example.nyarticles.business.repositories.impl.ArticleListRepoImpl
import com.example.nyarticles.framework.datasource.remote.ArticlesListApi
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import com.example.nyarticles.framework.datasource.remote.implementation.ArticleListDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ArticleListApiProviderModule {


    @Singleton
    @Provides
    fun provideArticlesListApi(retrofit: Retrofit): ArticlesListApi =
        retrofit.create(ArticlesListApi::class.java)
    @Singleton
    @Provides
    fun provideArticlesListDataSource(articlesListApi: ArticlesListApi): ArticlesListDataSource =
        ArticleListDataSourceImpl(articlesListApi)

    @Singleton
    @Provides
    fun provideArticlesListRepo(dataSource: ArticlesListDataSource): ArticleListRepoImpl =
        ArticleListRepoImpl(dataSource)

}