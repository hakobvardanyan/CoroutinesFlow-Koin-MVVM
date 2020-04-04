package com.example.coroutinesflow_koin_mvvm.feature.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesflow_koin_mvvm.extension.clicks
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@ExperimentalCoroutinesApi
abstract class BaseViewHolder<T : BaseItem>(view: View) : RecyclerView.ViewHolder(view) {

    protected var boundData: T? = null

    val clicksFlow: Flow<T?> = itemView.clicks().map { boundData }

    abstract fun bind(data: T)

}