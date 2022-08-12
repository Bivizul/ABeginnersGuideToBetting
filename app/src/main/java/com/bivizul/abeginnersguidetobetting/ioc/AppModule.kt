package com.bivizul.abeginnersguidetobetting.ioc

import com.bivizul.abeginnersguidetobetting.data.network.NetworkModule
import dagger.Module

@Module(includes = [NetworkModule::class])
class AppModule