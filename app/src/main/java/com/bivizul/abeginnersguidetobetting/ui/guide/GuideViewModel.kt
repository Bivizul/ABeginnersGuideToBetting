package com.bivizul.abeginnersguidetobetting.ui.guide

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bivizul.abeginnersguidetobetting.data.repository.GuidanceRepository
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import javax.inject.Inject

class GuideViewModel @Inject constructor(
    private val guidanceRepository: GuidanceRepository,
) : ViewModel() {

    val guidance = guidanceRepository.guidance

    init {
        getGuidance()
    }

    fun getGuidance() {
        viewModelScope.launch {
            guidanceRepository.getGuidanceList()
        }
    }

}

class GuideViewModelFactory @AssistedInject constructor(
    private val guidanceRepository: GuidanceRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GuideViewModel(guidanceRepository) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(): GuideViewModelFactory
    }

}