package com.gkalal.newsapp.presentation.di

import com.gkalal.newsapp.domain.repositories.NewsRepository
import com.gkalal.newsapp.domain.usecase.GetHeadlinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideNewsHeadlinesUseCase(newsRepository: NewsRepository): GetHeadlinesUseCase {
        return GetHeadlinesUseCase(newsRepository)
    }
}