package com.example.feature_1.di

import androidx.lifecycle.ViewModel
import com.example.feature_1.Feature2ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.gureev.core.view_model.ViewModelKey

@Module
abstract class Feature2ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(Feature2ViewModel::class)
    @Feature2Scope
    abstract fun bindFeature1ViewModel(viewModel: Feature2ViewModel): ViewModel
}
