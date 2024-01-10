package com.example.feature_2.adapter

import ru.gureev.delegates.DiffAdapter
import ru.gureev.delegates.listener.ListItemClickListener

class MarketNewsAdapter(onClickListener: ListItemClickListener) : DiffAdapter() {
    init {
        delegatesManager
            .addDelegate(marketNewsItemViewModelDelegate(onClickListener))
    }
}
