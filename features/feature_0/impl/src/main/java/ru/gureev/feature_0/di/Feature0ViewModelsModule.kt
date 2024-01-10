package ru.gureev.feature_0.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import ru.gureev.core.view_model.ViewModelKey
import ru.gureev.data.market_news.FinnHubService
import ru.gureev.data.market_news.IMarketNewsLocalDatasource
import ru.gureev.data.market_news.IMarketNewsRemoteDatasource
import ru.gureev.data.market_news.IMarketNewsRepository
import ru.gureev.data.market_news.MarketNewsLocalDatasource
import ru.gureev.data.market_news.MarketNewsRemoteDatasource
import ru.gureev.data.market_news.MarketNewsRepository
import ru.gureev.feature_0.Feature0ViewModel
import ru.gureev.feature_0.LoadAndSaveMarketNewsUseCase

@Module(includes = [Feature0ViewModelsModule.DataBinds::class])
class Feature0ViewModelsModule {

    @Provides
    fun providesLoadAndSaveMarketNewsUseCase(marketNewsRepository: IMarketNewsRepository): LoadAndSaveMarketNewsUseCase {
        return LoadAndSaveMarketNewsUseCase(
            repository = marketNewsRepository
        )
    }

    @Provides
    fun providesFinnHubService(retrofit: Retrofit): FinnHubService {
        return retrofit.create(FinnHubService::class.java)
    }

    @Module
    interface DataBinds {

        @Binds
        @IntoMap
        @ViewModelKey(Feature0ViewModel::class)
        fun bindFeature0nViewModel(viewModel: Feature0ViewModel): ViewModel

        @Binds
        fun bindsMarketNewsRemoteDatasource(value: MarketNewsRemoteDatasource): IMarketNewsRemoteDatasource

        @Binds
        fun bindsMarketNewsLocalDatasource(value: MarketNewsLocalDatasource): IMarketNewsLocalDatasource

        @Binds
        fun bindsMarketNewsRepository(value: MarketNewsRepository): IMarketNewsRepository

//        @Binds
//        @Feature0Scope
//        fun bindsLoadAndSaveMarketNewsUseCase(value: LoadAndSaveMarketNewsUseCase): LoadAndSaveMarketNewsUseCase
//

    }
}
