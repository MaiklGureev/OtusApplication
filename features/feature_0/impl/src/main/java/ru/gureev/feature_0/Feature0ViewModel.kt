package ru.gureev.feature_0

import ru.gureev.core.BaseViewModel
import ru.gureev.core.extensions.launchAsyncTryCatch
import javax.inject.Inject

class Feature0ViewModel @Inject constructor(
    private val loadAndSaveMarketNewsUseCase: LoadAndSaveMarketNewsUseCase
) : BaseViewModel() {

    init {
        launchAsyncTryCatch {
            loadAndSaveMarketNewsUseCase.invoke()
        }
    }
}
