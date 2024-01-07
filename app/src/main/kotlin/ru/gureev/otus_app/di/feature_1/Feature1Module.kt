package ru.gureev.otus_app.di.feature_1

import dagger.Binds
import dagger.Module
import ru.gureev.otus_app.di.feature_0.Feature0ViewModelsModule
import ru.gureev.otus_app.domain.Feature1UseCase
import ru.gureev.otus_app.domain.Feature2UseCase
import ru.gureev.otus_app.navigation.MainRouter

@Module
abstract class Feature1Module {
    // всякие зависимости для вью моделей

    @Binds
    abstract fun bindsFeature2UseCase(feature1UseCase: Feature2UseCase): Feature2UseCase

    @Binds
    abstract fun bindsFeature1UseCase(feature1UseCase:Feature1UseCase): Feature1UseCase
}
