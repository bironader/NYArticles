package com.example.nyarticles.business.usecases

interface GetArtcileListUseCase {

    suspend fun getArtcilesFromRepo(): ApiResponseWraper<Article>
}