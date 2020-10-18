package com.forceson.www.blueprint.data

data class Repo(
    val id: Long,
    val name: String,
    val fullName: String,
    val owner: User,
    val description: String?,
    val fork: Boolean,
    val stargazersCount: Int,
    val watchersCount: Int,
    val forksCount: Int,
    val language: String
)