package ru.gureev.otus_app.resources

import android.content.Context
import androidx.core.content.ContextCompat
import ru.gureev.core.extensions.unsafeLazy
import ru.gureev.core.resources.IColorResources
import javax.inject.Inject

class ColorResources @Inject constructor(
    val context: Context
) : IColorResources {

    private fun lazyColor(colorResId: Int) = unsafeLazy {
        ContextCompat.getColor(context, colorResId)
    }
}
