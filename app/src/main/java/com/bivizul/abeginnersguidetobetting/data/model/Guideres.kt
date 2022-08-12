package com.bivizul.abeginnersguidetobetting.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Guideres(
    @SerializedName("url")
    val guideres: String,
)
