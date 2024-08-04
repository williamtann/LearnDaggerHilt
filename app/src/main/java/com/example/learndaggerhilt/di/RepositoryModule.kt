package com.example.learndaggerhilt.di

import com.example.learndaggerhilt.data.RemoteRepositoryImpl
import com.example.learndaggerhilt.domain.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl): RemoteRepository
}