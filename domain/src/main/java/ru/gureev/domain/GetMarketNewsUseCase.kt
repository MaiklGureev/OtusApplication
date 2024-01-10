package ru.gureev.domain

import ru.gureev.data.market_news.IMarketNewsRepository
import ru.gureev.models.ui.MarketNewsUI
import javax.inject.Inject

class GetMarketNewsUseCase @Inject constructor(
    private val repository: IMarketNewsRepository
) : IGetMarketNewsUseCase {

    override suspend fun invoke(category: String): List<MarketNewsUI> {
        return repository.getMarketNews(category).map { it.mapToMarketNewsUI() }
    }

}

interface IGetMarketNewsUseCase {
    suspend operator fun invoke(category: String): List<MarketNewsUI>
}
