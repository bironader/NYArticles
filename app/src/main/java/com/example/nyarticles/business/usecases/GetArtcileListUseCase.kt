package com.example.nyarticles.business.usecases

import com.example.nyarticles.business.entites.Article
import com.example.nyarticles.business.entites.Result

interface GetArtcileListUseCase {

    suspend fun getArtcilesFromRepo(
        onSuccess: (Result<Article>) -> Unit,
        onFailed: (Throwable) -> Unit
    )
}