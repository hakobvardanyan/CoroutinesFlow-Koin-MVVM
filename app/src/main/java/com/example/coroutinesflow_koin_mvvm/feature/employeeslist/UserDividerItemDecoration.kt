package com.example.coroutinesflow_koin_mvvm.feature.employeeslist

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class UserDividerItemDecoration(
    private val dividerColor: Int,
    private val dividerHeight: Int
) : RecyclerView.ItemDecoration() {

    private val divider by lazy { ColorDrawable(dividerColor) }
    private val bounds = Rect()

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        c.save()
        val itemCount = parent.adapter?.itemCount ?: 0
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)
            if (position == RecyclerView.NO_POSITION) break
            if (position != itemCount - 1) {
                drawCommonDivider(parent, child, c)
            }
        }
        c.restore()
    }

    private fun drawCommonDivider(parent: RecyclerView, child: View, canvas: Canvas) {
        val leftOffset = child.width / 5
        parent.getDecoratedBoundsWithMargins(child, bounds)
        val bottom = bounds.bottom
        val top = bottom - dividerHeight
        divider.setBounds(leftOffset, top, parent.width, bottom)
        divider.draw(canvas)
    }
}