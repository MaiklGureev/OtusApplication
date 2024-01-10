package ru.gureev.models.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.gureev.models.domain.MarketNews

@Entity
data class MarketNewsEntity(
    @PrimaryKey
    var id: Int?,

    @ColumnInfo("category")
    var category: String?,

    @ColumnInfo("datetime")
    var datetime: Long?,

    @ColumnInfo("headline")
    var headline: String?,

    @ColumnInfo("image")
    var image: String?,

    @ColumnInfo("related")
    var related: String?,

    @ColumnInfo("source")
    var source: String?,

    @ColumnInfo("summary")
    var summary: String?,

    @ColumnInfo("url")
    var url: String?
) {
    fun mapToMarketNews(): MarketNews {
        return MarketNews(
            id = id ?: 0,
            category = category.orEmpty(),
            datetime = datetime ?: 0,
            headline = headline.orEmpty(),
            image = image.orEmpty(),
            related = related.orEmpty(),
            source = source.orEmpty(),
            summary = summary.orEmpty(),
            url = url.orEmpty()
        )
    }
}
