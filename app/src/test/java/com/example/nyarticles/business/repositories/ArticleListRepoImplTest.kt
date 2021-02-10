package com.example.nyarticles.business.repositories

import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.business.repositories.abstraction.ArticleListRepo
import com.example.nyarticles.business.repositories.impl.ArticleListRepoImpl
import com.example.nyarticles.framework.datasource.remote.abstraction.ArticlesListDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test


@ExperimentalCoroutinesApi
class ArticleListRepoImplTest {


    private lateinit var repoImpl: ArticleListRepo


    @ExperimentalCoroutinesApi
    @Test
    fun `fetchArticle()_success_returnResponse`() {
        runBlockingTest {

            //Arrange
            val result = emptyList<ArticleDomainModel>() // empty list
            repoImpl = ArticleListRepoImpl(object : ArticlesListDataSource {
                override suspend fun getArticles() = result
            })

            //Act
            var success: List<ArticleDomainModel>? = null
            var throwable: Throwable? = null
            val flow = repoImpl.fetchArticles()
            flow.catch { throwable = it }
                .collect { success = it }


            // Assert
            assertNotNull(success)
            assertNull(throwable)
            assertEquals(success, result)
        }

    }


    @ExperimentalCoroutinesApi
    @Test
    fun `fetchArticle()_failed_returnThrowable`() {
        runBlockingTest {

            //Arrange
            val result = Throwable("Http Exception") // empty list
            repoImpl = ArticleListRepoImpl(object : ArticlesListDataSource {
                override suspend fun getArticles() = throw result
            })

            //Act
            var success: List<ArticleDomainModel>? = null
            var throwable: Throwable? = null
            val flow = repoImpl.fetchArticles()
            flow.catch { throwable = it }
                .collect { success = it }


            // Assert
            assertNotNull(throwable)
            assertNull(success)
            assertEquals(throwable?.message, result.message)
        }

    }

}