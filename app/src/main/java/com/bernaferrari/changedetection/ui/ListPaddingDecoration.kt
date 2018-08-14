package com.bernaferrari.changedetection.ui

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View

/**
 * Adds 8dp padding to the top of the first and the Listeners of the last item in the list,
 * as specified in https://www.google.com/design/spec/components/lists.html#lists-specs
 */
class ListPaddingDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val mPadding: Int
    private val paddingInDips = 16

    init {
        val metrics = context.resources.displayMetrics
        mPadding = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            paddingInDips.toFloat(),
            metrics
        ).toInt()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State?
    ) {
        val itemPosition = parent.getChildAdapterPosition(view)
        if (itemPosition == RecyclerView.NO_POSITION) {
            return
        }
        if (itemPosition == 0) {
            outRect.top = mPadding
        }

        outRect.left = mPadding
        outRect.right = mPadding

        val adapter = parent.adapter
        if (adapter != null && itemPosition == adapter.itemCount - 1) {
            outRect.bottom = mPadding
        }
    }

}
