package ru.gureev.otus_app.di.core

import android.content.SharedPreferences
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.gureev.otus_app.navigation.MainRouter
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
    fun provideRouter(cicerone:Cicerone<MainRouter>): MainRouter{
        return cicerone.router
    }

    @Singleton
    @Provides
    fun provideNavigatorHolder(cicerone:Cicerone<MainRouter>): NavigatorHolder{
        return cicerone.getNavigatorHolder()
    }
}
