package com.bivizul.abeginnersguidetobetting.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.bivizul.abeginnersguidetobetting.R
import com.bivizul.abeginnersguidetobetting.appComponent
import com.bivizul.abeginnersguidetobetting.data.Constant.BACK_3
import com.bivizul.abeginnersguidetobetting.databinding.ActivityMainBinding
import com.bivizul.abeginnersguidetobetting.ui.utils.checkConnect
import com.bivizul.abeginnersguidetobetting.ui.utils.getDER


class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        if (!checkConnect(this)) {
            getDER(this, this)
        } else {
            setContentView(R.layout.activity_main)
            binding.back1.load(BACK_3)
        }
    }
}