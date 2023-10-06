package com.example.newsapp.ui.news_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.InterestingCardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsDetailsViewModel : ViewModel() {
    private val _stateInterestingCardModel = MutableStateFlow<InterestingCardModel?>(null)
    val stateInterestingCardModel: StateFlow<InterestingCardModel?> = _stateInterestingCardModel
    fun loadState(interestingCardModel: InterestingCardModel) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateInterestingCardModel.emit(interestingCardModel)
        }
    }
}