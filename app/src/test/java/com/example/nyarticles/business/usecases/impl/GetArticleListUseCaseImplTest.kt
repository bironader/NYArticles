package com.example.nyarticles.business.usecases.impl

import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.business.repositories.abstraction.ArticleListRepo
import com.example.nyarticles.business.usecases.abstraction.GetArtcileListUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test

@ExperimentalCoroutinesApi
class GetArticleListUseCaseImplTest {

    private lateinit var articleListUseCaseImpl: GetArtcileListUseCase


    @ExperimentalCoroutinesApi
    @Test
    fun `fetchArticle()_success_returnResponse`() {
        runBlockingTest {

            //Arrange
            val result = listOf(
                ArticleDomainModel(
                    "testTitle",
                    "testImage",
                    "testByLine",
                    "testPublishedData",
                    "testAbstract"
                )
            )
            articleListUseCaseImpl = GetArticleListUseCaseImpl(object : ArticleListRepo {
                override suspend fun fetchArticles() = flow { emit(result) }

            })

            //Act
            var success: List<ArticleDomainModel>? = null
            var throwable: Throwable? = null
            val flow = articleListUseCaseImpl.getArtciles()
            flow.catch { throwable = it }
                .collect { success = it }


            // Assert
            assertNotNull(success)
            assertNull(throwable)
            assertEquals(success, result)
            assertEquals(result[0].title, success?.get(0)?.title)
            assertEquals(result[0].image, success?.get(0)?.image)
            assertEquals(result[0].byline, success?.get(0)?.byline)
            assertEquals(result[0].abstract, success?.get(0)?.abstract)
        }

    }

    @Suppress("UNREACHABLE_CODE")
    @ExperimentalCoroutinesApi
    @Test
    fun `fetchArticle()_error_returnThrowable`() {
        runBlockingTest {

            //Arrange
            val result = Throwable("Http Exception")
            articleListUseCaseImpl = GetArticleListUseCaseImpl(object : ArticleListRepo {
                override suspend fun fetchArticles() = flow {
                    throw result
                    emit(emptyList<ArticleDomainModel>())

                }

            })

            //Act
            var success: List<ArticleDomainModel>? = null
            var throwable: Throwable? = null
            val flow = articleListUseCaseImpl.getArtciles()
            flow.catch { throwable = it }
                .collect { success = it }


            // Assert
            assertNotNull(throwable)
            assertNull(success)
            assertEquals(throwable?.message, result.message)
        }

    }

}