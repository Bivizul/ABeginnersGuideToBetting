package com.bivizul.abeginnersguidetobetting.ui.guide

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bivizul.abeginnersguidetobetting.data.model.Guide
import com.bivizul.abeginnersguidetobetting.databinding.ItemGuideBinding

class GuideAdapter : ListAdapter<Guide, GuideViewHolder>(GuideDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val binding = ItemGuideBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GuideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            with(item) {
                @Suppress("DEPRECATION")
                textViewGuide.text = Html.fromHtml("<font><b>${title}</b></font> $subtitle")
            }
        }
    }
}