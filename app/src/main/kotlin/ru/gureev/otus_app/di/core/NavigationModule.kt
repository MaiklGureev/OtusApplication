package ru.gureev.otus_app.di.core

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Module
import dagger.Provides
import ru.gureev.core.navigation.MainRouter
import javax.inject.Singleton

@Module
object NavigationModule {
    @Singleton
    @Provides
    fun provideStorage(): Cicerone<MainRouter> {
        return Cicerone.create(MainRouter())
    }

    @Singleton
    @Provides
    fun provideRouter(cicerone: Cicerone<MainRouter>): MainRouter {
        return cicerone.router
    }

    @Singleton
    @Provides
    fun provideNavigatorHolder(cicerone: Cicerone<MainRouter>): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }
}
