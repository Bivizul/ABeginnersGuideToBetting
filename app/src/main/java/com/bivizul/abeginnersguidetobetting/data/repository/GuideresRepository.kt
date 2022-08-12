package com.bivizul.abeginnersguidetobetting.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bivizul.abeginnersguidetobetting.data.Constant.ERROR_MESSAGE
import com.bivizul.abeginnersguidetobetting.data.model.Guideloc
import com.bivizul.abeginnersguidetobetting.data.model.Guideres
import com.bivizul.abeginnersguidetobetting.data.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GuideresRepository @Inject constructor(private val networkService: NetworkService) {

    private val _guideres = MutableLiveData<Guideres>()
    val guideres: LiveData<Guideres> = _guideres

    suspend fun getGuideres(guideloc: Guideloc) {
        withContext(Dispatchers.IO) {
            val response = networkService.getGuideres(guideloc)
            if (response.isSuccessful) {
                response.body()?.let {
                    _guideres.postValue(it)
                }
            } else {
                _guideres.postValue(Guideres(ERROR_MESSAGE))
            }
        }
    }
}