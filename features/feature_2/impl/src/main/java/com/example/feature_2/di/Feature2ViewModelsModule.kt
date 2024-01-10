package com.example.feature_2.di

import androidx.lifecycle.ViewModel
import com.example.feature_2.Feature2ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.gureev.core.view_model.ViewModelKey

@Module(includes = [Feature2ViewModelsModule.DataBinds::class])
abstract class Feature2ViewModelsModule {

    @Module
    interface DataBinds {
        @Binds
        @IntoMap
        @ViewModelKey(Feature2ViewModel::class)
        fun bindFeature1ViewModel(viewModel: Feature2ViewModel): ViewModel
    }
}
