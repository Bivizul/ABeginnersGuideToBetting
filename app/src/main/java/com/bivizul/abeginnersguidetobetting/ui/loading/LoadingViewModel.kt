package com.bivizul.abeginnersguidetobetting.ui.loading

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bivizul.abeginnersguidetobetting.data.Constant.ERROR_MESSAGE
import com.bivizul.abeginnersguidetobetting.data.model.Guideloc
import com.bivizul.abeginnersguidetobetting.data.model.Guideres
import com.bivizul.abeginnersguidetobetting.data.repository.GuideresRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoadingViewModel @Inject constructor(
    private val guideloc: Guideloc,
    private val guideresRepository: GuideresRepository,
) : ViewModel() {

    /*val guideres: SharedFlow<Guideres> =
        flow<Guideres> {
//            val response = guideresRepository.getGuideres(guideloc)
//            Log.e("qwer","LoadingViewModel : $response")
//            if (response.isSuccessful) {
//                response.body()?.let {
//                    it
//                }
//            } else {
//                Guideres(ERROR_MESSAGE)
//            }
            Log.e("qwer", "LoadingViewModel : ${guideresRepository.getGuideres(guideloc)}")
            guideresRepository.getGuideres(guideloc)
//            getGuideres()
        }
            .shareIn(viewModelScope, SharingStarted.Lazily, replay = 1)*/

    val guideres = guideresRepository.guideres

    fun getGuideres(){
        viewModelScope.launch {
            guideresRepository.getGuideres(guideloc)
        }
    }

    /*fun getGuideres():Guideres{
        var a = Guideres(ERROR_MESSAGE)
        viewModelScope.launch(Dispatchers.IO) {
            val response = guideresRepository.getGuideres(guideloc)
            Log.e("qwer","LoadingViewModel getGuideres: $response")
            if (response.isSuccessful) {
                response.body()?.let {
                    a = it

                }
            } else {
                a = Guideres(ERROR_MESSAGE)
            }
        }
        Log.e("qwer","a: $a")
        return a
    }*/

}

class LoadingViewModelFactory @AssistedInject constructor(
    @Assisted("guideloc") private val guideloc: Guideloc,
    private val guideresRepository: GuideresRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == LoadingViewModel::class)
        return LoadingViewModel(guideloc, guideresRepository) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("guideloc") guideloc: Guideloc): LoadingViewModelFactory
    }

}