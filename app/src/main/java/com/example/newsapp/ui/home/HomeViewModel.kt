package com.example.newsapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _stateCategoryCardModel = MutableStateFlow<Int>(0)
    val stateCategoryCardModel: StateFlow<Int> = _stateCategoryCardModel
    fun loadState(categoryCardModel: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateCategoryCardModel.emit(categoryCardModel)
        }
    }
}