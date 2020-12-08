package com.example.nyarticles.business.repositories

import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Result
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class ArticleListRepoTest {


    @Mock
    lateinit var onFailed: (Throwable) -> Unit

    @Mock
    lateinit var onSuccess: (Result<Article>) -> Unit

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `fetchArticle()_success_invokeSuccess`() {
        runBlockingTest {

            //Arrange
            val result = Result<Article>(emptyList()) // empty list

            val articleListRepo = ArticleListRepo(object : ArticlesListDataSource {
                override suspend fun getArticles() = result
            })


            //Act
            articleListRepo.fetchArticles(onSuccess, onFailed)


            // Assert
            verify(onSuccess).invoke(result)
        }

    }

    @ExperimentalCoroutinesApi
    @Test
    fun `fetchArticle()_failed_invokeFailed`() {
        runBlockingTest {

            //Arrange
            val throwable = Throwable("Http Error") // exception

            val articleListRepo = ArticleListRepo(object : ArticlesListDataSource {
                override suspend fun getArticles(): Result<Article> {
                    throw throwable // exception raised
                }
            })

            //Act
            articleListRepo.fetchArticles(onSuccess, onFailed)


            // Assert
            verify(onFailed).invoke(throwable)
        }

    }

}