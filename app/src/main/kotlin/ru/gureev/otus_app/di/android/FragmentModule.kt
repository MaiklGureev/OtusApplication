package ru.gureev.otus_app.di.android

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.gureev.otus_app.di.feature_0.Feature0Scope
import ru.gureev.otus_app.di.feature_0.Feature0ViewModelsModule
import ru.gureev.otus_app.di.feature_1.Feature1Scope
import ru.gureev.otus_app.di.feature_1.Feature1ViewModelsModule
import ru.gureev.otus_app.feature_0.Feature0Fragment
import ru.gureev.otus_app.feature_1.Feature1Fragment

@Module()
abstract class FragmentModule {
    @Feature0Scope
    @ContributesAndroidInjector(
        modules = [
//            Feature0Module::class,
            Feature0ViewModelsModule::class,
        ]

    )
    abstract fun contributeSplashScreenFragment(): Feature0Fragment

    @Feature1Scope
    @ContributesAndroidInjector(
        modules = [
//            Feature1Module::class,
            Feature1ViewModelsModule::class,
        ]

    )
    abstract fun contributeFeature1Fragment(): Feature1Fragment


}

