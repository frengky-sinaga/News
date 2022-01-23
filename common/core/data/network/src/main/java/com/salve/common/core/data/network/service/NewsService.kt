package com.salve.common.core.data.network.service

import com.salve.common.core.data.network.model.TopHeadlinesDto
import com.salve.common.core.data.network.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): TopHeadlinesDto
}