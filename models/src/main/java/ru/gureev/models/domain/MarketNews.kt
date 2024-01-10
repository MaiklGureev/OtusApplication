package ru.gureev.models.domain

import ru.gureev.models.database.MarketNewsEntity

data class MarketNews(
    var id: Int,
    var category: String,
    var datetime: Int,
    var headline: String,
    var image: String,
    var related: String,
    var source: String,
    var summary: String,
    var url: String
) {
    fun mapToMarketNewsEntity(): MarketNewsEntity {
        return MarketNewsEntity(
            id = id,
            category = category,
            datetime = datetime,
            headline = headline,
            image = image,
            related = related,
            source = source,
            summary = summary,
            url = url
        )
    }
}
