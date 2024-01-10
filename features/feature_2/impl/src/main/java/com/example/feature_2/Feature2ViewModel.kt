package com.example.feature_2

import androidx.lifecycle.MutableLiveData
import ru.gureev.core.BaseViewModel
import ru.gureev.core.extensions.doOnMain
import ru.gureev.core.extensions.launchAsyncTryCatch
import ru.gureev.delegates.ListViewModel
import ru.gureev.domain.IGetMarketNewsUseCase
import ru.gureev.models.ui.MarketNewsUI
import javax.inject.Inject

class Feature2ViewModel @Inject constructor(
    private val getMarketNewsUseCase: IGetMarketNewsUseCase
) : BaseViewModel() {

    val marketNewsList = MutableLiveData<List<MarketNewsUI>>(emptyList())

    fun loadNews(category: String) {

        launchAsyncTryCatch {
            val marketNews = getMarketNewsUseCase.invoke(category)
            doOnMain {
                marketNewsList.value = marketNews
            }
        }
    }

    fun onItemClicked(clickedItem: ListViewModel) {

    }

}
