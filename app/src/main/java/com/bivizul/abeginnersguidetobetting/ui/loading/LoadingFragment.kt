package com.bivizul.abeginnersguidetobetting.ui.loading

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bivizul.abeginnersguidetobetting.R
import com.bivizul.abeginnersguidetobetting.appComponent
import com.bivizul.abeginnersguidetobetting.data.model.Guideloc
import com.bivizul.abeginnersguidetobetting.data.model.Guideres
import com.bivizul.abeginnersguidetobetting.databinding.FragmentLoadingBinding
import com.bivizul.abeginnersguidetobetting.ui.utils.getGuideres
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class LoadingFragment : Fragment(R.layout.fragment_loading) {

    private val binding by viewBinding(FragmentLoadingBinding::bind)
    val viewModel :LoadingViewModel by viewModels { factory.create(Guideloc(getGuideres(requireContext()))) }

    @Inject
    lateinit var factory: LoadingViewModelFactory.Factory

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.getGuideres(Guideloc(getGuideres(requireContext())))
        viewModel.getGuideres()
        viewModel.guideres.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                Log.e("qwer", "guideres : ${it.guideres}")
                binding.load.text = it.guideres
                if (it.guideres.length > 2) {
                    delay(1000)

//                    findNavController().navigate(
//                        R.id.action_loadingFragment_to_wodoFragment,
//                        bundleOf(KEY_OUT_RESPONSE to it.guideres)
//                    )
                    findNavController().navigate(R.id.action_loadingFragment_to_mainFragment)
                } else {
                    delay(1000)
                    findNavController().navigate(R.id.action_loadingFragment_to_mainFragment)
                }
            }
        }

         /*viewLifecycleOwner.lifecycle.coroutineScope.launch{
             viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
//                 viewModel.guideres.collect(::updateUi)
                 viewModel.guideres.collect{
                     Log.e("qwer","viewLifecycleOwner : ${it.guideres}")
                     binding.load.text = it.guideres
                 }
             }
         }*/

    }

    /*private fun updateUi(guideres: Guideres) {
        Log.e("qwer","updateUi : $guideres")
        if (view == null) return
        with(binding) {
//            title.text = news.title
//            body.text = news.body
            load.text = guideres.guideres
        }
    }*/
}