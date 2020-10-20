package com.forceson.www.blueprint.data

import com.google.gson.annotations.Expose

data class Issue(
    @Expose val id: Long,
    @Expose val title: String,
    @Expose val user: User,
    @Expose val state: String,
    @Expose val assignees: List<User>,
    @Expose val labels: List<Label>,
    @Expose val comments: Int,
    @Expose val body: String?
)