package com.example.feature_1.adapter

import com.example.feature_1.databinding.ItemNewsCategoryBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.gureev.delegates.ListViewModel
import ru.gureev.delegates.listener.ListItemClickListener
import ru.gureev.models.ui.NewsCategoryUI

fun newsCategoryItemViewModelDelegate(onClickListener: ListItemClickListener) =
    adapterDelegateViewBinding<NewsCategoryUI, ListViewModel, ItemNewsCategoryBinding>(
        { layoutInflater, root -> ItemNewsCategoryBinding.inflate(layoutInflater, root, false) }
    ) {
        with(binding) {
            root.setOnClickListener {
                onClickListener.onListItemClicked(item)
            }
            bind {
                tvTitle.text = item.category
            }
        }
    }

