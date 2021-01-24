package com.gkalal.newsapp.presentation.di

import android.app.Application
import com.gkalal.newsapp.domain.usecase.GetHeadlinesUseCase
import com.gkalal.newsapp.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class FactoryModule {

    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        application: Application,
        getHeadlinesUseCase: GetHeadlinesUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(application, getHeadlinesUseCase)
    }
}