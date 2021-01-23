package com.gkalal.newsapp.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiServiceTest {
    private lateinit var apiInterface: ApiInterface
    private lateinit var server: MockWebServer

    @Before
    fun setup() {
        server = MockWebServer()
        apiInterface = Retrofit.Builder().baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }

    @After
    fun teardown() {
        server.shutdown()
    }

    private fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("NewsResponse.json")
            val responseBody = apiInterface.getTopHeadlines("us",1).body()
            val request = server.takeRequest()

            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=e56e39a0a24d418e9c167d426db20186")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize(){
        runBlocking {
            enqueueMockResponse("NewsResponse.json")
            val responseBody = apiInterface.getTopHeadlines("us",1).body()
            val articleList = responseBody!!.articles

            assertThat(articleList.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("NewsResponse.json")
            val responseBody = apiInterface.getTopHeadlines("us",1).body()
            val articleList = responseBody!!.articles

            val article = articleList[0]
            assertThat(article.author).isEqualTo("Tom Kludt and Brad Parks, CNN")
        }
    }
}