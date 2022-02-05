package com.salve.settings

import androidx.lifecycle.ViewModel
import com.salve.common.core.domain.use_case.SettingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val useCase: SettingsUseCase) : ViewModel() {
    fun clearCache() = useCase.clearCache()
}