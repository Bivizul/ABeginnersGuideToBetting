package com.bivizul.abeginnersguidetobetting.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bivizul.abeginnersguidetobetting.R
import com.bivizul.abeginnersguidetobetting.appComponent
import com.bivizul.abeginnersguidetobetting.data.network.NetworkService
import javax.inject.Inject


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

//        if (!Util.checkConnect(this)){
//            Util.getDER(this,this)
//        } else {
//            setContentView(R.layout.activity_main)
//        }


    }
}