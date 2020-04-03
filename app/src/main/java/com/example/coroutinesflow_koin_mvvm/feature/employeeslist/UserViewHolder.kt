package com.example.coroutinesflow_koin_mvvm.feature.employeeslist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.coroutinesflow_koin_mvvm.R
import com.example.coroutinesflow_koin_mvvm.viewdata.UserViewData
import kotlinx.android.synthetic.main.user_item_view.view.*

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(user: UserViewData) {
        with(itemView) {
            Glide.with(context)
                .load(user.avatarUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .transform(CenterCrop())
                .transform(RoundedCorners(resources.getDimensionPixelOffset(R.dimen.radius_small)))
                .into(avatarView)

            nameView.text = user.name
            typeView.text = String.format(
                context.getString(R.string.profile_type_text),
                user.type
            )
        }
    }
}