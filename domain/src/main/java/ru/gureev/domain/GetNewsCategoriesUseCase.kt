package ru.gureev.domain

import ru.gureev.data.market_news.IMarketNewsRepository
import ru.gureev.models.ui.NewsCategoryUI
import javax.inject.Inject

class GetNewsCategoriesUseCase @Inject constructor(
    private val repository: IMarketNewsRepository
) : IGetNewsCategoriesUseCase {
    override suspend fun invoke(): List<NewsCategoryUI> {
        return repository.getMarketNewsCategories().map { NewsCategoryUI(category = it) }
    }

}

interface IGetNewsCategoriesUseCase {
    suspend operator fun invoke(): List<NewsCategoryUI>
}
