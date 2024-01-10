package ru.gureev.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.gureev.data.market_news.FinnHubService
import ru.gureev.data.market_news.IMarketNewsLocalDatasource
import ru.gureev.data.market_news.IMarketNewsRemoteDatasource
import ru.gureev.data.market_news.IMarketNewsRepository
import ru.gureev.data.market_news.MarketNewsLocalDatasource
import ru.gureev.data.market_news.MarketNewsRemoteDatasource
import ru.gureev.data.market_news.MarketNewsRepository

@Module(includes = [DataModule.DataBinds::class])
class DataModule {

    @Provides
    fun providesFinnHubService(retrofit: Retrofit): FinnHubService {
        return retrofit.create(FinnHubService::class.java)
    }

    @Module
    interface DataBinds {

        @Binds
        fun bindsMarketNewsRemoteDatasource(value: MarketNewsRemoteDatasource): IMarketNewsRemoteDatasource

        @Binds
        fun bindsMarketNewsLocalDatasource(value: MarketNewsLocalDatasource): IMarketNewsLocalDatasource

        @Binds
        fun bindsMarketNewsRepository(value: MarketNewsRepository): IMarketNewsRepository

    }
}
