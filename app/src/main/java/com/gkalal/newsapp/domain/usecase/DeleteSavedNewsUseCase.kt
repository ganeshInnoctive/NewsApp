package com.gkalal.newsapp.domain.usecase

import com.gkalal.newsapp.data.model.Article
import com.gkalal.newsapp.domain.repositories.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}