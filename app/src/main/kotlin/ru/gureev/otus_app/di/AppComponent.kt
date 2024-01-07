package ru.gureev.otus_app.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.gureev.otus_app.App
import ru.gureev.otus_app.core.BaseActivity
import ru.gureev.otus_app.di.android.ActivityModule
import ru.gureev.otus_app.di.core.AppModule
import ru.gureev.otus_app.di.core.NavigationModule
import ru.gureev.otus_app.di.core.NetworkModule
import ru.gureev.otus_app.di.core.view_model.ViewModelFactoryModule
import ru.gureev.otus_app.di.feature_0.Feature0Module
import ru.gureev.otus_app.di.feature_1.Feature1Module
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
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

    fun inject(activity: BaseActivity)
}




