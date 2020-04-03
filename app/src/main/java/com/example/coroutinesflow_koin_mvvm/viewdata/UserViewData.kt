package com.example.coroutinesflow_koin_mvvm.viewdata

data class UserViewData(
    val id: Long,
    val url: String,
    val name: String,
    val type: String,
    val following: Int,
    val followers: Int,
    val location: String,
    val avatarUrl: String,
    val createdAt: String
)