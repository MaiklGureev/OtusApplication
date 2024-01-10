package ru.gureev.models.network

import com.google.gson.annotations.SerializedName
import ru.gureev.models.domain.MarketNews


data class MarketNewsResponse(
    @SerializedName("category")
    var category: String? = null,

    @SerializedName("datetime")
    var datetime: Int? = null,

    @SerializedName("headline")
    var headline: String? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("related")
    var related: String? = null,

    @SerializedName("source")
    var source: String? = null,

    @SerializedName("summary")
    var summary: String? = null,

    @SerializedName("url")
    var url: String? = null
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
