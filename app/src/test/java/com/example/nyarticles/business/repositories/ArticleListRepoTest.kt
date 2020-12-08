package com.example.nyarticles.business.repositories

import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Result
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


class ArticleListRepoTest {


    lateinit var repo: ArticleListRepo


    @ExperimentalCoroutinesApi
    @Test
    fun `fetchArticle()_success_returnResponse`() {
        runBlockingTest {

            //Arrange
            val result = Result<Article>(emptyList()) // empty list
            repo = ArticleListRepo(object : ArticlesListDataSource {
                override suspend fun getArticles() = result
            })

            //Act
            val response = repo.fetchArticles()

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
            repo = ArticleListRepo(object : ArticlesListDataSource {
                override suspend fun getArticles() = throw result
            })

            //Act
            val response = repo.fetchArticles()

            // Assert
            assertNotNull(response.throwable)
        }

    }

}