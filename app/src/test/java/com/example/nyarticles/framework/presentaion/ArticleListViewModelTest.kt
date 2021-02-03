package com.example.nyarticles.framework.presentaion

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.nyarticles.TestCoroutineRule
import com.example.nyarticles.business.entites.Resource
import com.example.nyarticles.business.entites.Resource.*
import com.example.nyarticles.business.usecases.GetArtcileListUseCase
import com.example.nyarticles.framework.presentaion.articlelist.ArticleListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ArticleListViewModelTest {


    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()


    @Mock
    private lateinit var stateObserver: Observer<Resource<Result<Article>>>

    @Mock
    lateinit var useCase: GetArtcileListUseCase

    private lateinit var viewModel: ArticleListViewModel

    @Before
    fun setup() {
        viewModel = ArticleListViewModel(useCase)
        viewModel.stateLiveData.observeForever(stateObserver)
    }

    @Test
    fun `fetchArticle()_failed_postSuccessResource`() {
        testCoroutineRule.runBlockingTest {

            //Arrange
            val successResponse =
                ApiResponseWraper(Result<Article>(emptyList()), null) // empty list
            `when`(useCase.getArtcilesFromRepo()).thenReturn(successResponse)

            //Act
            viewModel.fetchArticles()

            // Assert
            verify(stateObserver).onChanged(Success(successResponse.result!!))

        }

    }


    @Test
    fun `fetchArticle()_success_postFailedResource`() {
        testCoroutineRule.runBlockingTest {

            //Arrange
            val errorResponse =
                ApiResponseWraper(Result<Article>(null), Throwable())

                        // empty list
            `when`(useCase.getArtcilesFromRepo()).thenReturn(errorResponse)

            //Act
            viewModel.fetchArticles()

            // Assert
            verify(stateObserver).onChanged(Failure(errorResponse.throwable.getType()!!))

        }

    }

}