package com.example.feature_1

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.example.feature_1.databinding.FragmentFeature2Binding
import ru.gureev.core.BaseFragment

class Feature2Fragment : BaseFragment<FragmentFeature2Binding, Feature2ViewModel>(
    FragmentFeature2Binding::inflate,
    Feature2ViewModel::class.java
) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            tvTitle.text = "${tvTitle.text}  ${viewModel.hashCode()}"
            tvTitle.setOnClickListener {
                viewModel.invokeUseCase()
            }
        }
    }

    companion object {

        fun newInstance(): Feature2Fragment {
            val args = bundleOf(

            )

            return Feature2Fragment().apply {
                arguments = args
            }
        }
    }
}
