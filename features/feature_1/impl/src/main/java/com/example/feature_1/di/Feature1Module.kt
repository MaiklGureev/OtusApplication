package com.example.feature_1.di

import com.example.feature_1.domain.Feature1UseCase
import dagger.Binds
import dagger.Module

@Module
abstract class Feature1Module {
    // всякие зависимости для вью моделей

    @Binds
    abstract fun bindsFeature1UseCase(feature1UseCase: Feature1UseCase): Feature1UseCase
}
