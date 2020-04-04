package com.example.data.mapper

import com.example.data.model.api.UserApiModel
import com.example.data.model.database.UserDatabaseModel
import com.example.domain.model.UserModel

object UserDataMapper {

    fun transformFromApiModel(from: UserApiModel): UserModel {
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

    fun transformFromApiModel(from: List<UserApiModel>): List<UserModel> {
        return from.map { transformFromApiModel(it) }
    }

    fun transformFromApiToDatabaseModel(from: UserApiModel): UserDatabaseModel {
        return UserDatabaseModel(
            id = from.id,
            url = from.url,
            name = from.name ?: "",
            type = from.type,
            login = from.login ?: "",
            nodeId = from.nodeId ?: "",
            htmlUrl = from.htmlUrl ?: "",
            location = from.location ?: "",
            reposUrl = from.reposUrl ?: "",
            gistsUrl = from.gistsUrl ?: "",
            following = from.following ?: 0,
            followers = from.followers ?: 0,
            avatarUrl = from.avatarUrl,
            eventsUrl = from.eventsUrl ?: "",
            siteAdmin = from.siteAdmin ?: false,
            updatedAt = from.updatedAt ?: "",
            createdAt = from.createdAt ?: "",
            grAvatarId = from.grAvatarId ?: "",
            starredUrl = from.starredUrl ?: "",
            publicRepos = from.publicRepos ?: 0,
            publicGists = from.publicGists ?: 0,
            followersUrl = from.followersUrl ?: "",
            followingUrl = from.followingUrl ?: "",
            subscriptionsUrl = from.subscriptionsUrl ?: "",
            organizationsUrl = from.organizationsUrl ?: "",
            receivedEventsUrl = from.receivedEventsUrl ?: ""
        )
    }

    fun transformFromApiToDatabaseModel(from: List<UserApiModel>): List<UserDatabaseModel> {
        return from.map { transformFromApiToDatabaseModel(it) }
    }

    fun transformFromDatabaseModel(from: UserDatabaseModel): UserModel {
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

    fun transformFromDatabaseModel(from: List<UserDatabaseModel>): List<UserModel> {
        return from.map { transformFromDatabaseModel(it) }
    }

}