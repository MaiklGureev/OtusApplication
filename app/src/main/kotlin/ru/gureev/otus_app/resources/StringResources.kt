package ru.gureev.otus_app.resources

import android.content.Context
import ru.gureev.core.extensions.unsafeLazy
import ru.gureev.core.resources.IStringResources
import ru.gureev.otus_app.R
import javax.inject.Inject

class StringResources @Inject constructor(
    private val context: Context,
) : IStringResources {

    override val appTitle: String by lazyString(R.string.app_name)

    override val loading: String by lazyString(ru.gureev.feature_0.R.string.loading)

    private fun lazyString(stringId: Int) = unsafeLazy {
        context.getString(stringId)
    }
}
