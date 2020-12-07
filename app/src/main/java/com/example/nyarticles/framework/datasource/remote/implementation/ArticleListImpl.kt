package com.example.nyarticles.framework.datasource.remote.implementation

import com.example.nyarticles.framework.datasource.remote.ArticlesListApi
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import javax.inject.Inject


class ArticleListImpl @Inject constructor(articlesListApi: ArticlesListApi) :
    ArticlesListDataSource {
}