package ru.gureev.otus_app.di.feature_0

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.gureev.otus_app.di.core.view_model.ViewModelKey
import ru.gureev.otus_app.di.feature_1.Feature1Module
import ru.gureev.otus_app.feature_0.Feature0ViewModel

@Module
abstract class Feature0ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(Feature0ViewModel::class)
    @Feature0Scope
    abstract fun bindFeature0nViewModel(viewModel: Feature0ViewModel): ViewModel
}
