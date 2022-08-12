package com.bivizul.abeginnersguidetobetting.data.network

import com.bivizul.abeginnersguidetobetting.data.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    fun provideBaseUrl() = BASE_URL

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl:String) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NetworkService::class.java)

}