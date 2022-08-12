package com.bivizul.abeginnersguidetobetting.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bivizul.abeginnersguidetobetting.R
import com.bivizul.abeginnersguidetobetting.appComponent
import com.bivizul.abeginnersguidetobetting.ui.utils.checkConnect
import com.bivizul.abeginnersguidetobetting.ui.utils.getDER


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        if (!checkConnect(this)) {
            getDER(this, this)
        } else {
            setContentView(R.layout.activity_main)
        }
    }
}