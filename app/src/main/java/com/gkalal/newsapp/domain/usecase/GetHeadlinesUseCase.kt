package com.gkalal.newsapp.domain.usecase

import com.gkalal.newsapp.data.model.NewsApiResponse
import com.gkalal.newsapp.data.util.Resource
import com.gkalal.newsapp.domain.repositories.NewsRepository

class GetHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Resource<NewsApiResponse> {
        return newsRepository.getNewsHeadlines()
    }
}