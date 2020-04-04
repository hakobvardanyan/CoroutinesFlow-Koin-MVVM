package com.example.coroutinesflow_koin_mvvm.feature.base

import androidx.recyclerview.widget.DiffUtil

abstract class DiffUtilCallback<T : BaseItem> : DiffUtil.Callback() {

    protected var oldList = emptyList<T>()
    protected var newList = emptyList<T>()

    fun submitLists(newList: List<T>, oldList: List<T>) {
        this.newList = newList
        this.oldList = oldList
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(old: Int, new: Int) = oldList[old].id == newList[new].id

}