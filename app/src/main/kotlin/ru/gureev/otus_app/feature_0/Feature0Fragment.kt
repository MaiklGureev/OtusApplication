package ru.gureev.otus_app.feature_0

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import ru.gureev.otus_app.Screens
import ru.gureev.otus_app.core.BaseFragment
import ru.gureev.otus_app.databinding.FragmentFeature0Binding

class Feature0Fragment : BaseFragment<FragmentFeature0Binding, Feature0ViewModel>(
    FragmentFeature0Binding::inflate,
    Feature0ViewModel::class.java
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            tvTitle.text = "${tvTitle.text}  ${viewModel.hashCode()}"
            tvTitle.setOnClickListener {
                viewModel.router.navigateTo(Screens.Feature1Screen())
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
