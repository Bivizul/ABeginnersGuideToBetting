package com.bivizul.abeginnersguidetobetting.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bivizul.abeginnersguidetobetting.data.model.GuidanceList
import com.bivizul.abeginnersguidetobetting.data.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GuidanceRepository @Inject constructor(private val networkService: NetworkService) {

    private val _guidance = MutableLiveData<GuidanceList>()
    val guidance: LiveData<GuidanceList> = _guidance

    suspend fun getGuidanceList() {
        withContext(Dispatchers.IO) {
            val response = networkService.getGuidanceList()
            if (response.isSuccessful) {
                response.body()?.let {
                    _guidance.postValue(it)
                }
            } else {
                _guidance.postValue(GuidanceList(emptyList()))
            }
        }
    }
}