package com.bivizul.abeginnersguidetobetting

import android.app.Application
import android.content.Context
import com.bivizul.abeginnersguidetobetting.ioc.AppComponent
import com.bivizul.abeginnersguidetobetting.ioc.DaggerAppComponent


class ABGTBApp : Application() {

    //    val appComponent by lazy { DaggerAppComponent.create() }
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()

        /*//TODO(OneSignal)
//        // Enable verbose OneSignal logging to debug issues if needed.
//        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
//
//        // OneSignal Initialization
//        OneSignal.initWithContext(this)
//        OneSignal.setAppId(ONESIGNAL_APP_ID)

        AppsFlyerLib.getInstance().init(AF_DEV_KEY, null, this)
        AppsFlyerLib.getInstance().start(this)*/

    }

//    companion object {
//        /**
//         * Shortcut to get [App] instance from any context, e.g. from Activity.
//         */
//        fun get(context: Context): ABGTBApp = context.applicationContext as ABGTBApp
//    }
}

/**
 * Специальное расширение для получения AppComponent в любом месте, где у вас есть доступ к Context.
 * Позволяет избегать статического хранения ссылки на ваш [Application] класс
 */
val Context.appComponent: AppComponent
    get() = when (this) {
        is ABGTBApp -> appComponent
        else -> applicationContext.appComponent
    }