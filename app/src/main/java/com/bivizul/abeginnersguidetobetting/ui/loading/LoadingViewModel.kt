package com.bivizul.abeginnersguidetobetting.ui.loading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bivizul.abeginnersguidetobetting.data.model.Guideloc
import com.bivizul.abeginnersguidetobetting.data.repository.GuideresRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoadingViewModel @Inject constructor(
    private val guideloc: Guideloc,
    private val guideresRepository: GuideresRepository,
) : ViewModel() {

    val guideres = guideresRepository.guideres

    fun getGuideres() {
        viewModelScope.launch {
            guideresRepository.getGuideres(guideloc)
        }
    }
}

class LoadingViewModelFactory @AssistedInject constructor(
    @Assisted("guideloc") private val guideloc: Guideloc,
    private val guideresRepository: GuideresRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoadingViewModel(guideloc, guideresRepository) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("guideloc") guideloc: Guideloc): LoadingViewModelFactory
    }

}