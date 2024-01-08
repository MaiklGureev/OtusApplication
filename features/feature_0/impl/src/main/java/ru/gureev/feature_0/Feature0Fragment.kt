package ru.gureev.feature_0

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import ru.gureev.api.Feature1Screen
import ru.gureev.core.BaseFragment
import ru.gureev.feature_0.databinding.FragmentFeature0Binding
import javax.inject.Inject


class Feature0Fragment : BaseFragment<FragmentFeature0Binding, Feature0ViewModel>(
    FragmentFeature0Binding::inflate,
    Feature0ViewModel::class.java
) {

    @Inject
    lateinit var feature1Screen: Feature1Screen

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            tvTitle.text = "${tvTitle.text}  ${viewModel.hashCode()}"
            tvTitle.setOnClickListener {
                viewModel.router.navigateTo(feature1Screen.createFeature1Screen())
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
