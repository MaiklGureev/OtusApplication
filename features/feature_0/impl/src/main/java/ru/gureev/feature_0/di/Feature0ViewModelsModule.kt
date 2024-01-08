package ru.gureev.feature_0.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.gureev.core.view_model.ViewModelKey
import ru.gureev.feature_0.Feature0ViewModel

@Module
abstract class Feature0ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(Feature0ViewModel::class)
    @Feature0Scope
    abstract fun bindFeature0nViewModel(viewModel: Feature0ViewModel): ViewModel
}
