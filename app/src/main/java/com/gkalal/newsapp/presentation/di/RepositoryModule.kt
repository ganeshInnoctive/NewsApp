package com.gkalal.newsapp.presentation.di

import com.gkalal.newsapp.data.repository.dataSource.NewsRemoteDataSource
import com.gkalal.newsapp.domain.repositories.NewsRepository
import com.gkalal.newsapp.domain.repositories.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}