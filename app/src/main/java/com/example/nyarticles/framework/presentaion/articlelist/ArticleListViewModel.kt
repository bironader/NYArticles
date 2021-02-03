package com.example.nyarticles.framework.presentaion.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nyarticles.business.entites.ArticleDomainModel
import com.example.nyarticles.business.entites.Resource
import com.example.nyarticles.business.entites.Resource.*
import com.example.nyarticles.business.usecases.GetArtcileListUseCase
import com.example.nyarticles.framework.utils.getType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
@ExperimentalCoroutinesApi
class ArticleListViewModel @Inject constructor(
    private val getArtcileListUseCase: GetArtcileListUseCase

) : ViewModel() {

    val stateLiveData: LiveData<Resource<List<ArticleDomainModel>>>
        get() = _stateLiveData
    private val _stateLiveData = MutableLiveData<Resource<List<ArticleDomainModel>>>()

    init {
        fetchArticles()
    }

    fun fetchArticles() {
        viewModelScope.launch {

            getArtcileListUseCase.getArtciles()
                .onStart {
                    _stateLiveData.value = Loading()
                }
                .catch {
                    _stateLiveData.value = Failure(it.getType())
                }
                .collect {
                    _stateLiveData.value = Success(it)
                }
        }


    }


}