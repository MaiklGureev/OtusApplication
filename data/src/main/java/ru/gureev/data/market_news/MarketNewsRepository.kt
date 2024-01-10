package ru.gureev.data.market_news

import ru.gureev.models.database.MarketNewsEntity
import ru.gureev.models.network.MarketNewsResponse
import javax.inject.Inject

class MarketNewsRepository @Inject constructor(
    private val localDatasource: IMarketNewsLocalDatasource,
    private val remoteDatasource: IMarketNewsRemoteDatasource,
) : IMarketNewsRepository {
    override suspend fun loadMarketNews(category: String, lastId: Int?): List<MarketNewsResponse> {
        return remoteDatasource.getMarketNews(category, lastId)
    }

    override suspend fun saveMarketNews(news: List<MarketNewsEntity>) {
        return localDatasource.insertMarketNews(news)
    }
}

interface IMarketNewsRepository {
    suspend fun loadMarketNews(category: String, lastId: Int? = null): List<MarketNewsResponse>
    suspend fun saveMarketNews(news: List<MarketNewsEntity>)
}
