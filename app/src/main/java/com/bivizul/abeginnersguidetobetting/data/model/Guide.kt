package com.bivizul.abeginnersguidetobetting.data.model

import androidx.annotation.Keep

@Keep
data class Guide(
    val id: Int,
    val title: String,
    val subtitle: String,
)