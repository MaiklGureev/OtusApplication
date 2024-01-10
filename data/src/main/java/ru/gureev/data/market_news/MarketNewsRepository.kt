package ru.gureev.data.market_news

import ru.gureev.models.database.MarketNewsEntity
import ru.gureev.models.domain.MarketNews
import javax.inject.Inject

class MarketNewsRepository @Inject constructor(
    private val localDatasource: IMarketNewsLocalDatasource,
    private val remoteDatasource: IMarketNewsRemoteDatasource,
) : IMarketNewsRepository {

    override suspend fun loadMarketNews(category: String, lastId: Int?): List<MarketNews> {
        return remoteDatasource.getMarketNews(category, lastId).map { it.mapToMarketNews() }
    }

    override suspend fun saveMarketNews(news: List<MarketNewsEntity>) {
        return localDatasource.insertMarketNews(news)
    }

    override suspend fun getMarketNews(category: String): List<MarketNews> {
        return localDatasource.getMarketNews(category).map { it.mapToMarketNews() }
    }

    override suspend fun getMarketNewsCategories(): List<String> {
        return localDatasource.getMarketNewsCategories()
    }

}

interface IMarketNewsRepository {
    suspend fun loadMarketNews(category: String, lastId: Int? = null): List<MarketNews>
    suspend fun saveMarketNews(news: List<MarketNewsEntity>)

    suspend fun getMarketNews(category: String): List<MarketNews>
    suspend fun getMarketNewsCategories(): List<String>
}
