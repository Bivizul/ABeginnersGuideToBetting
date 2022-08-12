package com.bivizul.abeginnersguidetobetting.data.network

import com.bivizul.abeginnersguidetobetting.data.model.GuidanceList
import com.bivizul.abeginnersguidetobetting.data.model.Guideloc
import com.bivizul.abeginnersguidetobetting.data.model.Guideres
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkService {

    @GET("17QuestionsAboutSports/questions.json")
    suspend fun getGuidanceList(): Response<GuidanceList>

    @POST("21ABeginner%E2%80%99sGuideToBetting/guideres.php")
    suspend fun getGuideres(@Body guideloc: Guideloc): Response<Guideres>

}