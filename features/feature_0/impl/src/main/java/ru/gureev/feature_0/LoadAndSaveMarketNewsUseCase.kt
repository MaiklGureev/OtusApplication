package ru.gureev.feature_0

import ru.gureev.data.market_news.IMarketNewsRepository
import ru.gureev.models.NewsCategory
import javax.inject.Inject

class LoadAndSaveMarketNewsUseCase @Inject constructor(
    private val repository: IMarketNewsRepository
) {
    suspend operator fun invoke() {
        val count = 5
        val categoryList = listOf(
            NewsCategory.GENERAL.value,
            NewsCategory.CRYPTO.value,
            NewsCategory.FOREX.value,
            NewsCategory.MERGER.value,
        )
        categoryList.forEach { category ->
            loadAndSave(category, null, count)
        }
    }

    private suspend fun loadAndSave(category: String, id: Int?, count: Int) {
        var lastId = id
        for (i in 1..count) {
            val news = repository.loadMarketNews(category, lastId).map { it.mapToMarketNews() }
            repository.saveMarketNews(news.map { it.mapToMarketNewsEntity() })
            lastId = news.lastOrNull()?.id
            if (lastId == null) return
        }
    }
}
