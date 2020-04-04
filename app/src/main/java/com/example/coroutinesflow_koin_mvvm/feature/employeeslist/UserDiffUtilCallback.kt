package com.example.coroutinesflow_koin_mvvm.feature.employeeslist

import com.example.coroutinesflow_koin_mvvm.feature.base.DiffUtilCallback
import com.example.coroutinesflow_koin_mvvm.viewdata.UserViewData

class UserDiffUtilCallback : DiffUtilCallback<UserViewData>() {

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newItem = oldList[newItemPosition]
        val oldItem = newList[oldItemPosition]
        return oldItem.name == newItem.name
                && oldItem.avatarUrl == newItem.avatarUrl
                && oldItem.type == newItem.type
    }
}