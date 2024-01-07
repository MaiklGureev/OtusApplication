package ru.gureev.otus_app.domain

import android.app.Application
import javax.inject.Inject

class Feature2UseCase @Inject constructor(
//    val application: Application
) {
    fun goToSplashScreen(): Unit {
        println("Feature2UseCase")
    }

}
