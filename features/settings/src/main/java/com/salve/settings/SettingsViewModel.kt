package com.salve.settings

import androidx.lifecycle.ViewModel
import com.salve.common.core.domain.use_case.NewsUseCase
import javax.inject.Inject

class SettingsViewModel @Inject constructor(private val useCase: NewsUseCase) : ViewModel() {
    fun clearCache() {
    }
}