package com.example.data.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDatabaseModel(
    @PrimaryKey
    @ColumnInfo(name ="id")
    val id: Long,
    @ColumnInfo(name ="url")
    val url: String,
    @ColumnInfo(name ="name")
    val name: String?,
    @ColumnInfo(name ="type")
    val type: String,
    @ColumnInfo(name ="login")
    val login: String?,
    @ColumnInfo(name ="node_id")
    val nodeId: String,
    @ColumnInfo(name ="html_url")
    val htmlUrl: String,
    @ColumnInfo(name ="location")
    val location: String?,
    @ColumnInfo(name ="repos_url")
    val reposUrl: String,
    @ColumnInfo(name ="gists_url")
    val gistsUrl: String,
    @ColumnInfo(name ="followers")
    val followers: Int?,
    @ColumnInfo(name ="following")
    val following: Int?,
    @ColumnInfo(name ="avatar_url")
    val avatarUrl: String,
    @ColumnInfo(name ="events_url")
    val eventsUrl: String,
    @ColumnInfo(name ="site_admin")
    val siteAdmin: Boolean,
    @ColumnInfo(name ="updated_at")
    val updatedAt: String,
    @ColumnInfo(name ="created_at")
    val createdAt: String?,
    @ColumnInfo(name ="gravatar_id")
    val grAvatarId: String,
    @ColumnInfo(name ="starred_url")
    val starredUrl: String,
    @ColumnInfo(name ="public_repos")
    val publicRepos: Int,
    @ColumnInfo(name ="public_gists")
    val publicGists: Int,
    @ColumnInfo(name ="followers_url")
    val followersUrl: String,
    @ColumnInfo(name ="following_url")
    val followingUrl: String,
    @ColumnInfo(name ="subscriptions_url")
    val subscriptionsUrl: String,
    @ColumnInfo(name ="organizations_url")
    val organizationsUrl: String,
    @ColumnInfo(name ="received_events_url")
    val receivedEventsUrl: String
)