package ru.gureev.otus_app.di.core.view_model

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory

//    companion object {
//        @Singleton
//        @Provides
//        fun creators(): MutableMap<Class<out ViewModel>, Provider<ViewModel>> = mutableMapOf()
//    }


}
