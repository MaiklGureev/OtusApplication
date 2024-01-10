package com.example.feature_1.di

import androidx.lifecycle.ViewModel
import com.example.feature_1.Feature1ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.gureev.core.view_model.ViewModelKey

@Module(includes = [Feature1ViewModelsModule.DataBinds::class])
abstract class Feature1ViewModelsModule {
    @Module
    interface DataBinds {
        @Binds
        @IntoMap
        @ViewModelKey(Feature1ViewModel::class)
        fun bindFeature1ViewModel(viewModel: Feature1ViewModel): ViewModel
    }
}
