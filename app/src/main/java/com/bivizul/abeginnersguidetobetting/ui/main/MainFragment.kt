package com.bivizul.abeginnersguidetobetting.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bivizul.abeginnersguidetobetting.R
import com.bivizul.abeginnersguidetobetting.data.Constant.FOUR
import com.bivizul.abeginnersguidetobetting.data.Constant.GUIDE_ID
import com.bivizul.abeginnersguidetobetting.data.Constant.ONE
import com.bivizul.abeginnersguidetobetting.data.Constant.THREE
import com.bivizul.abeginnersguidetobetting.data.Constant.TWO
import com.bivizul.abeginnersguidetobetting.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)
////    private val viewModel: GuideViewModel by viewModels()
//
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            btnStructure.setOnClickListener{
                findNavController().navigate(
                    R.id.action_mainFragment_to_guideFragment,
                    bundleOf(GUIDE_ID to ONE)
                )
            }
            btnTypesOfBets.setOnClickListener{
                findNavController().navigate(
                    R.id.action_mainFragment_to_guideFragment,
                    bundleOf(GUIDE_ID to TWO)
                )
            }
            btnOtherTypes.setOnClickListener{
                findNavController().navigate(
                    R.id.action_mainFragment_to_guideFragment,
                    bundleOf(GUIDE_ID to THREE)
                )
            }
            btnGlossary.setOnClickListener{
                findNavController().navigate(
                    R.id.action_mainFragment_to_guideFragment,
                    bundleOf(GUIDE_ID to FOUR)
                )
            }

        }

    }



}