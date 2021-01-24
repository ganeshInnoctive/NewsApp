package com.gkalal.newsapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gkalal.newsapp.domain.usecase.GetHeadlinesUseCase

class NewsViewModelFactory(
    private val app: Application, private val getNewsHeadlinesUseCase: GetHeadlinesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(app, getNewsHeadlinesUseCase) as T
    }
}