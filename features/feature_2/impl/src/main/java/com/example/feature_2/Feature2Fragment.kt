package com.example.feature_2

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feature_1.databinding.FragmentFeature2Binding
import com.example.feature_2.adapter.MarketNewsAdapter
import com.example.feature_2.adapter.MarketNewsItemDecoration
import ru.gureev.core.BaseFragment

class Feature2Fragment : BaseFragment<FragmentFeature2Binding, Feature2ViewModel>(
    FragmentFeature2Binding::inflate,
    Feature2ViewModel::class.java
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadNews(arguments?.getString(ARG_CATEGORY).orEmpty())

        val marketNewsAdapter = MarketNewsAdapter { clickedItem ->
            viewModel.onItemClicked(clickedItem)
        }

        binding?.rv?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = marketNewsAdapter
            addItemDecoration(MarketNewsItemDecoration(requireContext().resources))
            viewModel.marketNewsList.observe(viewLifecycleOwner) { list -> marketNewsAdapter.swapItems(list) }
        }
    }

    companion object {
        const val ARG_CATEGORY = "category"

        fun newInstance(category: String): Feature2Fragment {
            val args = bundleOf(
                ARG_CATEGORY to category
            )

            return Feature2Fragment().apply {
                arguments = args
            }
        }
    }
}
