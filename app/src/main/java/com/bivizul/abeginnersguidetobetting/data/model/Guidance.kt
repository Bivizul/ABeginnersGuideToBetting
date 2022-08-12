package com.bivizul.abeginnersguidetobetting.data.model

import androidx.annotation.Keep

@Keep
data class Guidance(
    val id: Int,
    val nameGuide: String,
    val guide: List<Guide>,
)