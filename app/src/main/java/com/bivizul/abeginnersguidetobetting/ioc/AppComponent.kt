package com.bivizul.abeginnersguidetobetting.ioc

import com.bivizul.abeginnersguidetobetting.ui.MainActivity
import com.bivizul.abeginnersguidetobetting.ui.guide.GuideFragment
import com.bivizul.abeginnersguidetobetting.ui.loading.LoadingFragment
import com.bivizul.abeginnersguidetobetting.ui.main.MainFragment
import dagger.Component
import javax.inject.Singleton

// graph dependency
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(loadingFragment: LoadingFragment)
    fun inject(mainFragment: MainFragment)
    fun inject(guideFragment: GuideFragment)

    // можно как fun или property
    //    fun networkService():NetworkService
//    val networkService: NetworkService
//
//    fun loadingViewModel():LoadingViewModel
//    fun mainViewModel():MainViewModel
//    fun guideViewModel():GuideViewModel

}