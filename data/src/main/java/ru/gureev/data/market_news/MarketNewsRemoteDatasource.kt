package ru.gureev.data.market_news

import ru.gureev.models.network.MarketNewsResponse
import javax.inject.Inject

class MarketNewsRemoteDatasource @Inject constructor(
    private val api: FinnHubService
) : IMarketNewsRemoteDatasource {
    override suspend fun getMarketNews(category: String, lastId: Int?): List<MarketNewsResponse> {
        return api.getMarketNews(category, lastId)
    }
}

interface IMarketNewsRemoteDatasource {
    suspend fun getMarketNews(category: String, lastId: Int? = null): List<MarketNewsResponse>
}
