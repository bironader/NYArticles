package com.example.nyarticles.business.usecases

import com.example.nyarticles.business.entites.ArticleDomainModel
import kotlinx.coroutines.flow.Flow

interface GetArtcileListUseCase {

    suspend fun getArtciles(): Flow<List<ArticleDomainModel>>
}