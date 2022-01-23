package com.salve.features.news.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.salve.common.core.domain.use_case.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    newsUseCase: NewsUseCase
) : ViewModel() {

    val getTopHeadlines = newsUseCase.getTopHeadlines().asLiveData()
}