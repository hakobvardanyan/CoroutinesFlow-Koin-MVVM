package com.example.coroutinesflow_koin_mvvm.mapper

import com.example.coroutinesflow_koin_mvvm.viewdata.UserViewData
import com.example.domain.model.UserModel

object UserDataMapper {

    fun toViewData(from: UserModel): UserViewData {
        return UserViewData(
            id = from.id,
            url = from.url,
            name = if (from.name.isNotEmpty()) from.name else from.login,
            type = from.type,
            following = from.following,
            followers = from.followers,
            location = from.location,
            avatarUrl = from.avatarUrl,
            createdAt = from.createdAt
        )
    }

    fun toViewData(from: List<UserModel>): List<UserViewData> {
        return from.map { toViewData(it) }
    }

}