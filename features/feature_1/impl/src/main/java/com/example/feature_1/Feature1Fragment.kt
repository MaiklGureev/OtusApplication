package com.example.feature_1

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import com.example.feature_1.adapter.NewsCategoriesAdapter
import com.example.feature_1.adapter.NewsCategoryItemDecoration
import com.example.feature_1.databinding.FragmentFeature1Binding
import ru.gureev.core.BaseFragment

class Feature1Fragment : BaseFragment<FragmentFeature1Binding, Feature1ViewModel>(
    FragmentFeature1Binding::inflate,
    Feature1ViewModel::class.java
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewsCategoriesAdapter { clickedItem ->
            viewModel.onItemClicked(clickedItem)
        }

        binding?.apply {
            rv.layoutManager = GridLayoutManager(requireContext(), 2)
            rv.adapter = adapter
            rv.addItemDecoration(NewsCategoryItemDecoration(requireContext().resources))
            viewModel.categoriesList.observe(viewLifecycleOwner) { list -> adapter.swapItems(list) }
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
