package com.forceson.www.blueprint.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseListModel<T>(
    @Expose @SerializedName("total_count") val totalCount: Long,
    @Expose val items: ArrayList<T>
)