package com.forceson.www.blueprint.data

data class Issue(
    val id: Long,
    val title: String,
    val user: User,
    val state: String,
    val assignees: List<User>,
    val labels: List<Label>,
    val comments: Int,
    val body: String?
)