package com.example.feature_1.adapter

import ru.gureev.delegates.DiffAdapter
import ru.gureev.delegates.listener.ListItemClickListener

class NewsCategoriesAdapter(onClickListener: ListItemClickListener) : DiffAdapter() {
    init {
        delegatesManager
            .addDelegate(newsCategoryItemViewModelDelegate(onClickListener))
    }
}
