package com.example.nyarticles.framework.presentaion

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Resource
import com.example.nyarticles.business.entites.Resource.*
import com.example.nyarticles.business.entites.Result
import com.example.nyarticles.business.usecases.GetArticleListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ArtcileListViewModel @ViewModelInject constructor(
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
            try {
                _stateLiveData.postValue(Success(getArticleListUseCase.getArtcilesFromRepo()))
            } catch (exception: Throwable) {
                _stateLiveData.postValue(Failure(exception))
            }
        }

    }


}