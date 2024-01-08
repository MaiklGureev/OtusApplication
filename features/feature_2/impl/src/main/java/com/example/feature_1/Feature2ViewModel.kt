package com.example.feature_1

import ru.gureev.core.BaseViewModel
import javax.inject.Inject

class Feature2ViewModel @Inject constructor(
//   val feature1UseCase: Feature1UseCase
) : BaseViewModel() {

    fun invokeUseCase(): Unit {
//        feature1UseCase.goToSplashScreen()
    }
}
