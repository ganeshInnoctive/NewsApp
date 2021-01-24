package com.gkalal.newsapp.domain.repositories

import com.gkalal.newsapp.data.model.Article
import com.gkalal.newsapp.data.model.NewsApiResponse
import com.gkalal.newsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadlines(country: String, page: Int): Resource<NewsApiResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<NewsApiResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}