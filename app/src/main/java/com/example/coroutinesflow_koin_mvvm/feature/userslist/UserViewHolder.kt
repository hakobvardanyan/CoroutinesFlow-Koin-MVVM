package com.example.coroutinesflow_koin_mvvm.feature.userslist

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.coroutinesflow_koin_mvvm.R
import com.example.coroutinesflow_koin_mvvm.feature.base.BaseViewHolder
import com.example.coroutinesflow_koin_mvvm.viewdata.UserViewData
import kotlinx.android.synthetic.main.user_item_view.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class UserViewHolder(view: View) : BaseViewHolder<UserViewData>(view) {

    override fun bind(data: UserViewData) {
        boundData = data
        with(itemView) {
            Glide.with(context)
                .load(data.avatarUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .transform(CenterCrop())
                .transform(RoundedCorners(resources.getDimensionPixelOffset(R.dimen.radius_small)))
                .into(avatarView)

            nameView.text = data.name
            typeView.text = String.format(
                context.getString(R.string.profile_type_text),
                data.type
            )
        }
    }
}

