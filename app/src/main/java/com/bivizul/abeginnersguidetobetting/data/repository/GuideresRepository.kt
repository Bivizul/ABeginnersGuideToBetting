package com.bivizul.abeginnersguidetobetting.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bivizul.abeginnersguidetobetting.data.Constant.ERROR_MESSAGE
import com.bivizul.abeginnersguidetobetting.data.network.NetworkService
import com.bivizul.abeginnersguidetobetting.data.model.Guideloc
import com.bivizul.abeginnersguidetobetting.data.model.Guideres
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class GuideresRepository @Inject constructor(private val networkService: NetworkService) {

//    suspend fun getGuideres(guideloc: Guideloc) : Guideres {
//        return networkService.getGuideres(guideloc)
//    }

    private val _guideres = MutableLiveData<Guideres>()
    val guideres: LiveData<Guideres> = _guideres

    suspend fun getGuideres(guideloc: Guideloc) {
        Log.e("qwer","GuideresRepository getGuideres")
        withContext(Dispatchers.IO) {
            val response = networkService.getGuideres(guideloc)
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.e("qwer","GuideresRepository response : $it")
                    _guideres.postValue(it)
                }
            } else {
                _guideres.postValue(Guideres(ERROR_MESSAGE))
            }
        }
    }

}