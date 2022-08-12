package com.bivizul.abeginnersguidetobetting.data.model

import androidx.annotation.Keep

@Keep
data class Guidance(
    val guide: List<Guide>,
    val id: Int,
    val nameGuide: String
)