package com.example.coroutinesflow_koin_mvvm.feature.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow

@FlowPreview
@ExperimentalCoroutinesApi
abstract class BaseAdapter<T : BaseItem, H : BaseViewHolder<T>> : RecyclerView.Adapter<H>() {

    protected val clickChannel = ConflatedBroadcastChannel<T?>()
    protected val adapterScope = CoroutineScope(Dispatchers.Main)
    protected val items = mutableListOf<T>()

    protected abstract val diffCallback: DiffUtilCallback<T>

    fun itemClicks() = clickChannel.asFlow()

    fun getAllItems(): List<T> = items

    fun updateItems(newItems: List<T>) {
        diffCallback.submitLists(newItems, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = items.size

}