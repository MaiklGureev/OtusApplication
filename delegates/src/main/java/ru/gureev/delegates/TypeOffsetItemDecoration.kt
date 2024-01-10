package ru.gureev.delegates

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewHolder

abstract class TypeOffsetItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val item = parent.getItemByChild(view)
        getItemOffsets(outRect, item, parent)
    }

    private fun RecyclerView.getItemByChild(child: View): Any? {
        return when (val holder = getChildViewHolder(child)) {
            is AdapterDelegateViewBindingViewHolder<*, *> -> holder.item
            is AdapterDelegateViewHolder<*> -> holder.item
            else -> null
        }
    }

    protected abstract fun getItemOffsets(outRect: Rect, item: Any?, parent: RecyclerView)
}


