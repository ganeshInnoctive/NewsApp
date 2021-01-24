package com.gkalal.newsapp.data.repository.dataSourceImpl

import com.gkalal.newsapp.data.api.ApiInterface
import com.gkalal.newsapp.data.model.NewsApiResponse
import com.gkalal.newsapp.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(private val apiInterface: ApiInterface) : NewsRemoteDataSource {

    override suspend fun getTopHeadlines(country: String, page: Int): Response<NewsApiResponse> {
        return apiInterface.getTopHeadlines(country, page)
    }
}