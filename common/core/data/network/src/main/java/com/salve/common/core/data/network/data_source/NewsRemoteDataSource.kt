package com.salve.common.core.data.network.data_source

import com.salve.common.core.data.network.model.ArticleDto
import com.salve.common.core.data.network.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(
        country: String,
        category: String,
    ): Flow<ApiResponse<List<ArticleDto>>>
}