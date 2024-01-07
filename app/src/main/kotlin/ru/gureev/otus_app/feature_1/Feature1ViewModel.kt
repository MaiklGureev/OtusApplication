package ru.gureev.otus_app.feature_1

import ru.gureev.otus_app.core.BaseViewModel
import ru.gureev.otus_app.domain.Feature1UseCase
import ru.gureev.otus_app.navigation.MainRouter
import javax.inject.Inject

class Feature1ViewModel @Inject constructor (
   val feature1UseCase: Feature1UseCase
) : BaseViewModel() {

    fun invokeUseCase(): Unit {
        feature1UseCase.goToSplashScreen()
    }
}
