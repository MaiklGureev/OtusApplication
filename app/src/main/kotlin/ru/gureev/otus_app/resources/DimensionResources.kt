package ru.gureev.otus_app.resources

import android.content.Context
import androidx.annotation.DimenRes
import ru.gureev.core.extensions.unsafeLazy
import ru.gureev.core.resources.IDimensionResources

class DimensionResources(
    context: Context
) : IDimensionResources {

    private val resources = context.resources

    private fun dimenLazy(@DimenRes dimen: Int) = unsafeLazy {
        resources.getDimensionPixelSize(dimen)
    }
}
