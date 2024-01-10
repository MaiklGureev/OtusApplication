package ru.gureev.feature_0.di

import dagger.Module

@Module(includes = [Feature0Module.DataBinds::class])
class Feature0Module {

//    @Provides
//    fun providesFinnHubService(retrofit: Retrofit): FinnHubService {
//      return retrofit.create(FinnHubService::class.java)
//    }


    @Module
    interface DataBinds {

//       @Binds
//       fun bindsLoadAndSaveMarketNewsUseCase(value: LoadAndSaveMarketNewsUseCase): LoadAndSaveMarketNewsUseCase

//       @Binds
//       fun bindsMarketNewsRemoteDatasource(value: MarketNewsRemoteDatasource): IMarketNewsRemoteDatasource
//
//       @Binds
//       fun bindsMarketNewsLocalDatasource(value: MarketNewsLocalDatasource): IMarketNewsLocalDatasource
    }
}
