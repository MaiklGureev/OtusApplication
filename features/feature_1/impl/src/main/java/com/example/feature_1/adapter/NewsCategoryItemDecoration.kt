package com.example.feature_1.adapter

import android.content.res.Resources
import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import ru.gureev.delegates.TypeOffsetItemDecoration
import ru.gureev.models.ui.NewsCategoryUI

class NewsCategoryItemDecoration(
    resources: Resources
) : TypeOffsetItemDecoration() {
    private val s6 = resources.getDimensionPixelOffset(ru.gureev.design_system.R.dimen.size_6dp)
    private val s16 = resources.getDimensionPixelOffset(ru.gureev.design_system.R.dimen.size_16dp)

    override fun getItemOffsets(outRect: Rect, item: Any?, parent: RecyclerView) {
        when (item) {
            is NewsCategoryUI -> {
                outRect.set(s16, s6, s16, s6)
            }
        }
    }
}
