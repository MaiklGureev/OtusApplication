package ru.gureev.otus_app.domain

import retrofit2.Retrofit
import ru.gureev.otus_app.Screens
import ru.gureev.otus_app.navigation.MainRouter
import javax.inject.Inject

class Feature1UseCase @Inject constructor(
    val mainRouter: MainRouter,
    val feature2UseCase: Feature2UseCase,
    val retofit: Retrofit
) {
    fun goToSplashScreen(): Unit {
        mainRouter.backTo(Screens.Feature0Screen())
        feature2UseCase.goToSplashScreen()
    }

}
