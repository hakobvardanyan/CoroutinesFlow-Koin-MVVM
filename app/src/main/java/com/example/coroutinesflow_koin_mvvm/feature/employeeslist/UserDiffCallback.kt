package com.example.coroutinesflow_koin_mvvm.feature.employeeslist

import androidx.recyclerview.widget.DiffUtil
import com.example.coroutinesflow_koin_mvvm.viewdata.UserViewData

class UserDiffCallback : DiffUtil.ItemCallback<UserViewData>() {

    override fun areItemsTheSame(oldItem: UserViewData, newItem: UserViewData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserViewData, newItem: UserViewData): Boolean {
        return oldItem.name == newItem.name
                && oldItem.avatarUrl == newItem.avatarUrl
                && oldItem.createdAt == newItem.createdAt
    }
}