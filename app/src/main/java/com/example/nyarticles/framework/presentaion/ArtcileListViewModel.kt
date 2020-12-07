package com.example.nyarticles.framework.presentaion

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.nyarticles.business.usecases.GetArticleListUseCase

class ArtcileListViewModel @ViewModelInject constructor(
    private val getArticleListUseCase: GetArticleListUseCase,
    @Assisted
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    // TODO: Implement the ViewModel
}