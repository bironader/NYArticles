package com.example.nyarticles.business.usecases.abstraction

import com.example.nyarticles.business.entites.ArticleDomainModel
import kotlinx.coroutines.flow.Flow

interface GetArtcileListUseCase {

    suspend fun getArtciles(): Flow<List<ArticleDomainModel>>
}