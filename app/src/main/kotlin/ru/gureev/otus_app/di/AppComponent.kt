package ru.gureev.otus_app.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.gureev.core.view_model.ViewModelFactoryModule
import ru.gureev.data.DataModule
import ru.gureev.domain.DomainModule
import ru.gureev.otus_app.App
import ru.gureev.otus_app.di.android.ActivityModule
import ru.gureev.otus_app.di.core.AppModule
import ru.gureev.otus_app.di.core.NavigationModule
import ru.gureev.otus_app.di.core.NetworkModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        DomainModule::class,
        NavigationModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ActivityModule::class,
        AndroidSupportInjectionModule::class,
    ]
)

interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Context): Builder
    }

}




