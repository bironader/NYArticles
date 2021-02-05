package com.example.nyarticles.injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
class DispatcherProviderModule {
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Main

}