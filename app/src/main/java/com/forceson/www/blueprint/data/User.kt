package com.forceson.www.blueprint.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose val id: Long,
    @Expose @SerializedName("login") val name: String,
    @Expose @SerializedName("avatar_url") val avatarUrl: String?,
)