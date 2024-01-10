package ru.gureev.models.ui

import ru.gureev.delegates.ListViewModel

data class MarketNewsUI(
    var id: Int,
    var category: String,
    var datetime: String,
    var headline: String,
    var image: String,
    var source: String,
    var summary: String,
    var url: String
) : ListViewModel {

}
