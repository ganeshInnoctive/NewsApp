package com.gkalal.newsapp.presentation.di

import com.gkalal.newsapp.data.api.ApiInterface
import com.gkalal.newsapp.data.repository.dataSource.NewsRemoteDataSource
import com.gkalal.newsapp.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(apiInterface: ApiInterface): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(apiInterface)
    }
}