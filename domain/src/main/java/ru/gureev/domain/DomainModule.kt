package ru.gureev.domain

import dagger.Binds
import dagger.Module

@Module(includes = [DomainModule.DataBinds::class])
class DomainModule {

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
