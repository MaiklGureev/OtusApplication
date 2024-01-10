package ru.gureev.models.domain

import ru.gureev.core.common.DateFormats
import ru.gureev.core.extensions.format
import ru.gureev.models.database.MarketNewsEntity
import ru.gureev.models.ui.MarketNewsUI
import java.util.*

data class MarketNews(
    var id: Int,
    var category: String,
    var datetime: Long,
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

    fun mapToMarketNewsUI(): MarketNewsUI {
        return MarketNewsUI(
            id = id,
            category = category,
            datetime = Date().apply { time = datetime }.format(DateFormats.FORMAT_DATE_FULL),
            headline = headline,
            image = image,
            source = source,
            summary = summary,
            url = url
        )
    }
}
