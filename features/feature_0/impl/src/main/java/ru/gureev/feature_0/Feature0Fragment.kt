package ru.gureev.feature_0

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import ru.gureev.core.BaseFragment
import ru.gureev.feature_0.databinding.FragmentFeature0Binding


class Feature0Fragment : BaseFragment<FragmentFeature0Binding, Feature0ViewModel>(
    FragmentFeature0Binding::inflate,
    Feature0ViewModel::class.java
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel.counterText.observe(viewLifecycleOwner) {
                tvLoading.text = it
            }
        }
    }

    companion object {

        fun newInstance(): Feature0Fragment {
            val args = bundleOf(

            )

            return Feature0Fragment().apply {
                arguments = args
            }
        }
    }
}
