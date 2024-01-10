package ru.gureev.data.market_news

import ru.gureev.data.room.AppDatabase
import ru.gureev.models.database.MarketNewsEntity
import javax.inject.Inject

class MarketNewsLocalDatasource @Inject constructor(
    private val appDatabase: AppDatabase
) : IMarketNewsLocalDatasource {

    override suspend fun getMarketNews(category: String): List<MarketNewsEntity> {
        return appDatabase.marketNewsDao().getByCategory(category)
    }

    override suspend fun insertMarketNews(news: List<MarketNewsEntity>) {
        return appDatabase.marketNewsDao().insertAll(news)
    }

}

interface IMarketNewsLocalDatasource {
    suspend fun getMarketNews(category: String): List<MarketNewsEntity>
    suspend fun insertMarketNews(news: List<MarketNewsEntity>)
}
