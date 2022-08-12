package com.bivizul.abeginnersguidetobetting.ioc

import com.bivizul.abeginnersguidetobetting.ui.MainActivity
import com.bivizul.abeginnersguidetobetting.ui.guide.GuideFragment
import com.bivizul.abeginnersguidetobetting.ui.loading.LoadingFragment
import com.bivizul.abeginnersguidetobetting.ui.main.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(loadingFragment: LoadingFragment)
    fun inject(mainFragment: MainFragment)
    fun inject(guideFragment: GuideFragment)

}