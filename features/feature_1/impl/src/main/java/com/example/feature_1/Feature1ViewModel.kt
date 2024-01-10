package com.example.feature_1

import androidx.lifecycle.MutableLiveData
import ru.gureev.api.Feature2Screen
import ru.gureev.core.BaseViewModel
import ru.gureev.core.extensions.doOnMain
import ru.gureev.core.extensions.launchAsyncTryCatch
import ru.gureev.delegates.ListViewModel
import ru.gureev.domain.IGetNewsCategoriesUseCase
import ru.gureev.models.ui.NewsCategoryUI
import javax.inject.Inject

class Feature1ViewModel @Inject constructor(
    private val getNewsCategoriesUseCase: IGetNewsCategoriesUseCase,
    private val feature2Screen: Feature2Screen
) : BaseViewModel() {

    val categoriesList = MutableLiveData<List<NewsCategoryUI>>(emptyList())

    init {
        launchAsyncTryCatch {
            val categories = getNewsCategoriesUseCase.invoke()
            doOnMain {
                categoriesList.value = categories
            }
        }
    }


    fun onItemClicked(item: ListViewModel) {
        when (item) {
            is NewsCategoryUI -> {
                router.navigateTo(feature2Screen.createFeature2Screen(item.category))
            }
        }
    }
}
