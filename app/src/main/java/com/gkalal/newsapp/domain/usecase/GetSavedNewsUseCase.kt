package com.gkalal.newsapp.domain.usecase

import com.gkalal.newsapp.data.model.Article
import com.gkalal.newsapp.domain.repositories.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}