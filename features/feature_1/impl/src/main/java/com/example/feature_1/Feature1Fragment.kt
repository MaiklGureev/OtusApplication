package com.example.feature_1

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.example.feature_1.databinding.FragmentFeature1Binding
import ru.gureev.core.BaseFragment

class Feature1Fragment : BaseFragment<FragmentFeature1Binding, Feature1ViewModel>(
    FragmentFeature1Binding::inflate,
    Feature1ViewModel::class.java
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

        fun newInstance(): Feature1Fragment {
            val args = bundleOf(

            )

            return Feature1Fragment().apply {
                arguments = args
            }
        }
    }
}
