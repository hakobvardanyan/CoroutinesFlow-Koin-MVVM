package com.example.coroutinesflow_koin_mvvm.extension

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.core.content.ContextCompat

fun Context.color(@ColorRes id: Int): Int {
    return ContextCompat.getColor(this, id)
}

fun Context.dimenInt(@DimenRes id: Int): Int {
    return resources.getDimensionPixelOffset(id)
}

fun Context.dimenFloat(@DimenRes id: Int): Float {
    return resources.getDimension(id)
}