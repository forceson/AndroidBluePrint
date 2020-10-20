package com.forceson.www.blueprint.data

import com.google.gson.annotations.Expose

data class Label(
    @Expose val id: Long,
    @Expose val name: String,
    @Expose val color: String,
    @Expose val default: Boolean,
    @Expose val description: String?
)