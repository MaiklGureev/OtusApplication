package ru.gureev.otus_app.resources

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import ru.gureev.core.extensions.unsafeLazy
import ru.gureev.core.resources.IDrawableResources

class DrawableResources(
    private val context: Context
) : IDrawableResources {

//    override val icFinishedFailed: Drawable by lazyDrawable(R.drawable.ic_approve_white_circle_purple)

    private fun lazyDrawable(id: Int) = unsafeLazy {
        AppCompatResources.getDrawable(context, id)!!
    }
}
