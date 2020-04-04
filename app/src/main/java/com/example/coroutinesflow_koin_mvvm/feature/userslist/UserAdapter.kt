package com.example.coroutinesflow_koin_mvvm.feature.userslist

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.coroutinesflow_koin_mvvm.R
import com.example.coroutinesflow_koin_mvvm.feature.base.BaseAdapter
import com.example.coroutinesflow_koin_mvvm.viewdata.UserViewData
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@FlowPreview
@ExperimentalCoroutinesApi
class UserAdapter : BaseAdapter<UserViewData, UserViewHolder>() {

    override val diffCallback = UserDiffUtilCallback()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.user_item_view, parent, false)
        val userViewHolder = UserViewHolder(view)
        userViewHolder.clicksFlow
            .onEach { clickChannel.send(it) }
            .launchIn(adapterScope)
        return userViewHolder
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(items[position])
    }
}