package com.gkalal.newsapp.data.repository.dataSource

import com.gkalal.newsapp.data.model.NewsApiResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country: String, page: Int): Response<NewsApiResponse>
}