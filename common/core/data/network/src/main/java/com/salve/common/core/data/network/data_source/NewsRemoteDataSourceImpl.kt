package com.salve.common.core.data.network.data_source

import com.salve.common.core.data.network.model.ArticleDto
import com.salve.common.core.data.network.service.NewsService
import com.salve.common.core.data.network.utils.ApiResponse
import com.salve.common.core.data.network.utils.Constants.NEWS_API_STATUS_OK
import com.salve.common.core.data.network.utils.Constants.UNEXPECTED_ERROR_OCCUR
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(private val newsService: NewsService) :
    NewsRemoteDataSource {
    override suspend fun getTopHeadlines(
        country: String,
        category: String,
    ): Flow<ApiResponse<List<ArticleDto>>> {
        return flow {
            try {
                val response = newsService.getTopHeadlines(country, category)
                response.let {
                    when (it.status) {
                        NEWS_API_STATUS_OK -> {
                            if (!it.articles.isNullOrEmpty()) emit(ApiResponse.Success(it.articles))
                            else emit(ApiResponse.Empty)
                        }
                        else -> emit(
                            ApiResponse.Error(
                                it.message ?: "Error Requesting Data to Server"
                            )
                        )
                    }
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error("$UNEXPECTED_ERROR_OCCUR\n${e.localizedMessage}"))
            }
        }.flowOn(Dispatchers.IO)
    }
}