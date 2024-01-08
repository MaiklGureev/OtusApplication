package com.example.feature_1.di

import com.example.feature_1.domain.Feature2UseCase
import dagger.Binds
import dagger.Module

@Module
abstract class Feature2Module {
    // всякие зависимости для вью моделей

    @Binds
    abstract fun bindsFeature2UseCase(feature1UseCase: Feature2UseCase): Feature2UseCase
}
