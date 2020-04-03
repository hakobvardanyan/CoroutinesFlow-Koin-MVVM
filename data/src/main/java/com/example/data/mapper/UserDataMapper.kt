package com.example.data.mapper

import com.example.data.model.api.UserApiModel
import com.example.domain.model.UserModel

object UserDataMapper {

    fun transform(from: UserApiModel): UserModel {
        return UserModel(
            id = from.id,
            url = from.url,
            name = from.name ?: "",
            type = from.type,
            login = from.login ?: "",
            following = from.following ?: 0,
            followers = from.followers ?: 0,
            location = from.location ?: "",
            avatarUrl = from.avatarUrl,
            createdAt = from.createdAt ?: ""
        )
    }

    fun transform(from: List<UserApiModel>): List<UserModel> {
        return from.map { transform(it) }
    }

}