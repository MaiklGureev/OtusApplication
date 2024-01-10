package ru.gureev.feature_0.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.gureev.core.view_model.ViewModelKey
import ru.gureev.feature_0.Feature0ViewModel

@Module(includes = [Feature0ViewModelsModule.DataBinds::class])
class Feature0ViewModelsModule {


    @Module
    interface DataBinds {

        @Binds
        @IntoMap
        @ViewModelKey(Feature0ViewModel::class)
        fun bindFeature0nViewModel(viewModel: Feature0ViewModel): ViewModel

    }
}
