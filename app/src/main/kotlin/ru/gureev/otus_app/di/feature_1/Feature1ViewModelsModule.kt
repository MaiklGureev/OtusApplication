package ru.gureev.otus_app.di.feature_1

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.gureev.otus_app.di.core.view_model.ViewModelKey
import ru.gureev.otus_app.di.feature_0.Feature0Scope
import ru.gureev.otus_app.feature_1.Feature1ViewModel

@Module
abstract class Feature1ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(Feature1ViewModel::class)
    @Feature1Scope
    abstract fun bindFeature1ViewModel(viewModel: Feature1ViewModel): ViewModel
}
