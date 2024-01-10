package com.example.feature_1

import ru.gureev.api.Feature2Screen
import ru.gureev.core.BaseViewModel
import javax.inject.Inject

class Feature1ViewModel @Inject constructor(
    var feature2Screen: Feature2Screen
) : BaseViewModel() {

    fun invokeUseCase(): Unit {
        router.navigateTo(feature2Screen.createFeature2Screen())
    }
}
