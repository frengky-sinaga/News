package com.salve.common.core.domain.use_case

import com.salve.common.core.domain.repository.NewsRepository
import javax.inject.Inject

class SettingsUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository
) : SettingsUseCase {
    override fun clearCache() {
        newsRepository.deleteAllData()
    }
}