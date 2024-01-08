package com.example.feature_1.domain

import retrofit2.Retrofit
import ru.gureev.core.navigation.MainRouter
import javax.inject.Inject

class Feature1UseCase @Inject constructor(
    val mainRouter: MainRouter,
    val retofit: Retrofit
) {


}
