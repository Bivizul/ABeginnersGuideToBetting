package com.bivizul.abeginnersguidetobetting.ui.loading

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bivizul.abeginnersguidetobetting.R
import com.bivizul.abeginnersguidetobetting.appComponent
import com.bivizul.abeginnersguidetobetting.data.Constant.ERROR_MESSAGE
import com.bivizul.abeginnersguidetobetting.data.Constant.KEY_WODO
import com.bivizul.abeginnersguidetobetting.data.model.Guideloc
import com.bivizul.abeginnersguidetobetting.ui.utils.getDER
import com.bivizul.abeginnersguidetobetting.ui.utils.getGuideres
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoadingFragment : Fragment(R.layout.fragment_loading) {

    val viewModel: LoadingViewModel by viewModels {
        factory.create(Guideloc(getGuideres(requireContext())))
    }

    @Inject
    lateinit var factory: LoadingViewModelFactory.Factory

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getGuideres()
        viewModel.guideres.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                if (it.guideres == ERROR_MESSAGE) {
                    getDER(requireContext(), requireActivity())
                } else if (it.guideres.length > 2) {
                    delay(1000)
                    findNavController().navigate(
                        R.id.action_loadingFragment_to_wodoFragment,
                        bundleOf(KEY_WODO to it.guideres)
                    )
                } else {
                    delay(1000)
                    findNavController().navigate(R.id.action_loadingFragment_to_mainFragment)
                }
            }
        }
    }
}