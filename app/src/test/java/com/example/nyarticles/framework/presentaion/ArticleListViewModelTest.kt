package com.example.nyarticles.framework.presentaion

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.business.entites.Resource.*
import com.example.nyarticles.business.usecases.abstraction.GetArtcileListUseCase
import com.example.nyarticles.framework.presentaion.articlelist.ArticleListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ArticleListViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()


    private lateinit var viewModel: ArticleListViewModel


    @Test
    fun `fetchArticle()_failed_postSuccessResource`() {
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
            viewModel = ArticleListViewModel(object : GetArtcileListUseCase {
                override suspend fun getArtciles(): Flow<List<ArticleDomainModel>> {
                    return flow {
                        emit(result)
                    }
                }

            }, testDispatcher)


            // Act
            viewModel.fetchArticles()

            // Assert
            assertEquals(
                viewModel.stateLiveData.getOrAwaitValue(),
                Success(result)
            )

        }

    }


    @Suppress("UNREACHABLE_CODE")
    @Test
    fun `fetchArticle()_success_postFailedResource`() {
        runBlockingTest {

            //Arrange
            val result = Throwable("Http Exception")

            viewModel = ArticleListViewModel(object : GetArtcileListUseCase {
                override suspend fun getArtciles(): Flow<List<ArticleDomainModel>> {
                    return flow {
                        throw result
                        emit(emptyList<ArticleDomainModel>())
                    }
                }

            }, testDispatcher)


            // Act
            viewModel.fetchArticles()

            // Assert
            assertEquals(
                viewModel.stateLiveData.getOrAwaitValue(),
                Failure<List<ArticleDomainModel>>(result)
            )

        }

    }

    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS
    ): T {
        var data: T? = null
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(o: T?) {
                data = o
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }

        this.observeForever(observer)

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

        @Suppress("UNCHECKED_CAST")
        return data as T
    }


}