package ru.gureev.domain

import ru.gureev.data.market_news.IMarketNewsRepository
import javax.inject.Inject

class LoadAndSaveMarketNewsUseCase @Inject constructor(
    private val repository: IMarketNewsRepository
) : ILoadAndSaveMarketNewsUseCase {

    override suspend operator fun invoke(categoryList: List<String>, updateLoaderStatus: suspend (Int) -> Unit) {
        val count = 5
        categoryList.forEachIndexed { index, category ->
            updateLoaderStatus(index + 1)
            loadAndSave(category, null, count)
        }
    }

    private suspend fun loadAndSave(category: String, id: Int?, count: Int) {
        var lastId = id
        for (i in 1..count) {
            val news = repository.loadMarketNews(category, lastId)
            repository.saveMarketNews(news.map { it.mapToMarketNewsEntity() })
            lastId = news.lastOrNull()?.id
            if (lastId == null) return
        }
    }
}

interface ILoadAndSaveMarketNewsUseCase {
    suspend operator fun invoke(categoryList: List<String>, updateLoaderStatus: suspend (Int) -> Unit)
}
