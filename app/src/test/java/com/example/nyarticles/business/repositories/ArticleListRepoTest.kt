package com.example.nyarticles.business.repositories

import com.example.nyarticles.business.repositories.impl.ArticleListRepoImpl
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ArticleListRepoTest {



    lateinit var repoImpl: ArticleListRepoImpl



    @ExperimentalCoroutinesApi
    @Test
    fun `fetchArticle()_success_returnResponse`() {
        runBlockingTest {

            //Arrange
            val result = Result<Article>(emptyList()) // empty list
            repoImpl = ArticleListRepoImpl(object : ArticlesListDataSource {
                override suspend fun getArticles() = result
            })

            //Act
            val response = repoImpl.fetchArticles()

            // Assert
            assertNotNull(response.result)
        }

    }


    @ExperimentalCoroutinesApi
    @Test
    fun `fetchArticle()_failed_returnThrowable`() {
        runBlockingTest {

            //Arrange
            val result = Throwable("Http Error") // error
            repoImpl = ArticleListRepoImpl(object : ArticlesListDataSource {
                override suspend fun getArticles() = throw result
            })

            //Act
            val response = repoImpl.fetchArticles()

            // Assert
            assertNotNull(response.throwable)
        }

    }

}