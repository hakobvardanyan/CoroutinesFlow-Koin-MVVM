package com.example.data.model.api

import com.google.gson.annotations.SerializedName

data class UserApiModel(
    @SerializedName(value = "id")
    val id: Long,
    @SerializedName(value = "url")
    val url: String,
    @SerializedName(value = "name")
    val name: String?,
    @SerializedName(value = "type")
    val type: String,
    @SerializedName(value = "login")
    val login: String?,
    @SerializedName(value = "node_id")
    val nodeId: String?,
    @SerializedName(value = "html_url")
    val htmlUrl: String?,
    @SerializedName(value = "location")
    val location: String?,
    @SerializedName(value = "repos_url")
    val reposUrl: String?,
    @SerializedName(value = "gists_url")
    val gistsUrl: String?,
    @SerializedName(value = "followers")
    val followers: Int?,
    @SerializedName(value = "following")
    val following: Int?,
    @SerializedName(value = "avatar_url")
    val avatarUrl: String,
    @SerializedName(value = "events_url")
    val eventsUrl: String?,
    @SerializedName(value = "site_admin")
    val siteAdmin: Boolean?,
    @SerializedName(value = "updated_at")
    val updatedAt: String?,
    @SerializedName(value = "created_at")
    val createdAt: String?,
    @SerializedName(value = "gravatar_id")
    val grAvatarId: String?,
    @SerializedName(value = "starred_url")
    val starredUrl: String?,
    @SerializedName(value = "public_repos")
    val publicRepos: Int?,
    @SerializedName(value = "public_gists")
    val publicGists: Int?,
    @SerializedName(value = "followers_url")
    val followersUrl: String?,
    @SerializedName(value = "following_url")
    val followingUrl: String?,
    @SerializedName(value = "subscriptions_url")
    val subscriptionsUrl: String?,
    @SerializedName(value = "organizations_url")
    val organizationsUrl: String?,
    @SerializedName(value = "received_events_url")
    val receivedEventsUrl: String?
)