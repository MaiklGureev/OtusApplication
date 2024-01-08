package ru.gureev.otus_app.resources

import android.content.Context
import ru.gureev.core.extensions.unsafeLazy
import ru.gureev.core.resources.IStringResources
import ru.gureev.otus_app.R

class StringResources(
    private val context: Context,
) : IStringResources {

    override val appTitle: String by lazyString(R.string.app_name)

    private fun lazyString(stringId: Int) = unsafeLazy {
        context.getString(stringId)
    }
}
