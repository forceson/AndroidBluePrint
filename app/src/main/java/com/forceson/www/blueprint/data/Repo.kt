package com.forceson.www.blueprint.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Repo(
    @Expose val id: Long,
    @Expose val name: String,
    @Expose @SerializedName("full_name") val fullName: String,
    @Expose val owner: User,
    @Expose val description: String?,
    @Expose val fork: Boolean,
    @Expose @SerializedName("stargazers_count") val stargazersCount: Int,
    @Expose @SerializedName("watchers_count") val watchersCount: Int,
    @Expose @SerializedName("forks_count") val forksCount: Int,
    @Expose val language: String
)