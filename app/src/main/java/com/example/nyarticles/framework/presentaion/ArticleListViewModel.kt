package com.example.nyarticles.framework.presentaion

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Resource
import com.example.nyarticles.business.entites.Resource.*
import com.example.nyarticles.business.entites.Result
import com.example.nyarticles.business.usecases.GetArticleListUseCase
import com.example.nyarticles.framework.utils.getType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ArticleListViewModel @ViewModelInject constructor(
    private val getArticleListUseCase: GetArticleListUseCase,
    @Assisted
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val stateLiveData: LiveData<Resource<Result<Article>>>
        get() = _stateLiveData
    private val _stateLiveData = MutableLiveData<Resource<Result<Article>>>()


    fun fetchArticles() {
        viewModelScope.launch(Dispatchers.IO)
        {
            _stateLiveData.postValue(Loading())
            getArticleListUseCase.getArtcilesFromRepo(
                onSuccess = { _stateLiveData.postValue(Success(it)) },
                onFailed = { _stateLiveData.postValue(Failure(it.getType())) }
            )
        }

    }


}