package com.bivizul.abeginnersguidetobetting.ui.guide

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bivizul.abeginnersguidetobetting.R
import com.bivizul.abeginnersguidetobetting.appComponent
import com.bivizul.abeginnersguidetobetting.data.Constant.GUIDE_ID
import com.bivizul.abeginnersguidetobetting.data.Constant.ONE
import com.bivizul.abeginnersguidetobetting.databinding.FragmentGuideBinding
import com.bivizul.abeginnersguidetobetting.ui.utils.getDER
import javax.inject.Inject

class GuideFragment : Fragment(R.layout.fragment_guide) {

    private val binding by viewBinding(FragmentGuideBinding::bind)
    private val viewModel: GuideViewModel by viewModels { factory.create() }
    private val guideId by lazy { arguments?.getInt(GUIDE_ID) ?: ONE }
    private lateinit var guideAdapter: GuideAdapter

    @Inject
    lateinit var factory: GuideViewModelFactory.Factory

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViewGuide()

        viewModel.guidance.observe(viewLifecycleOwner) {
            if (it == null) {
                getDER(requireContext(), requireActivity())
            }
            for (i in it.guidance) {
                if (i.id == guideId) {
                    guideAdapter.submitList(i.guide)
                }
            }
        }
    }

    private fun setupRecyclerViewGuide() {
        with(binding.recyclerView) {
            guideAdapter = GuideAdapter()
            adapter = guideAdapter
        }
    }
}