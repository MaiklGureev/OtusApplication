package ru.gureev.domain

import android.content.Context
import android.net.ConnectivityManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DomainModule.DataBinds::class])
class DomainModule {

    @Provides
    @Singleton
    fun provideConnectivityManager(applicationContext: Context): ConnectivityManager {
        return applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Module
    interface DataBinds {
        @Binds
        fun bindsLoadAndSaveMarketNewsUseCase(value: LoadAndSaveMarketNewsUseCase): ILoadAndSaveMarketNewsUseCase

        @Binds
        fun bindsGetNewsCategoriesUseCase(value: GetNewsCategoriesUseCase): IGetNewsCategoriesUseCase

        @Binds
        fun bindsGetMarketNewsUseCase(value: GetMarketNewsUseCase): IGetMarketNewsUseCase
    }
}
