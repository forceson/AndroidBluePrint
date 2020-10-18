package com.forceson.www.blueprint.data

data class Label(
    val id: Long,
    val name: String,
    val color: String,
    val default: Boolean,
    val description: String?
)