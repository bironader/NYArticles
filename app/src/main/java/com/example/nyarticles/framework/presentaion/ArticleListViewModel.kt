package com.example.nyarticles.framework.presentaion

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Resource
import com.example.nyarticles.business.entites.Resource.*
import com.example.nyarticles.business.entites.Result
import com.example.nyarticles.business.usecases.GetArtcileListUseCase
import com.example.nyarticles.business.usecases.GetArticleListUseCaseImpl
import com.example.nyarticles.framework.utils.getType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleListViewModel @ViewModelInject constructor(
    private val getArtcileListUseCase: GetArtcileListUseCase

) : ViewModel() {

    val stateLiveData: LiveData<Resource<Result<Article>>>
        get() = _stateLiveData
    private val _stateLiveData = MutableLiveData<Resource<Result<Article>>>()


    fun fetchArticles() {
        viewModelScope.launch(Dispatchers.IO)
        {
            _stateLiveData.postValue(Loading())
            val response = getArtcileListUseCase.getArtcilesFromRepo()
            response.result?.let { result -> _stateLiveData.postValue(Success(result)) }
            response.throwable?.let { exception -> _stateLiveData.postValue(Failure(exception.getType())) }
        }

    }


}