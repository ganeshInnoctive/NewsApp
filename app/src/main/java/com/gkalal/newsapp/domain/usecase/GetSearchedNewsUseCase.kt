package com.gkalal.newsapp.domain.usecase

import com.gkalal.newsapp.data.model.NewsApiResponse
import com.gkalal.newsapp.data.util.Resource
import com.gkalal.newsapp.domain.repositories.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String): Resource<NewsApiResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}