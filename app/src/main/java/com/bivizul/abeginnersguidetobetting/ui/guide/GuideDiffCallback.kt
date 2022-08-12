package com.bivizul.abeginnersguidetobetting.ui.guide

import androidx.recyclerview.widget.DiffUtil
import com.bivizul.abeginnersguidetobetting.data.model.Guide

object GuideDiffCallback : DiffUtil.ItemCallback<Guide>() {

    override fun areItemsTheSame(oldItem: Guide, newItem: Guide): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Guide, newItem: Guide): Boolean {
        return oldItem == newItem
    }
}