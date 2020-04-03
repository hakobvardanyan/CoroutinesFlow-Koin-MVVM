package com.example.domain.model

data class UserModel(
    val id: Long,
    val url: String,
    val name: String,
    val type: String,
    val login: String,
    val following: Int,
    val followers: Int,
    val location: String,
    val avatarUrl: String,
    val createdAt: String
)