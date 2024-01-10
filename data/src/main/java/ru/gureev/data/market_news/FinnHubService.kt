package ru.gureev.data.market_news

import retrofit2.http.GET
import retrofit2.http.Query
import ru.gureev.models.network.MarketNewsResponse


interface FinnHubService {

    /**
     * Market News
     *
     * Get latest market news.
     * @param category This parameter can be 1 of the following values general, forex, crypto, merger.
     * @param minId Use this field to get only news after this ID. Default to 0
     */
    @GET("news")
    suspend fun getMarketNews(
        @Query("category") category: String? = null,
        @Query("minId") minId: Int? = null,
    ): List<MarketNewsResponse>
}
