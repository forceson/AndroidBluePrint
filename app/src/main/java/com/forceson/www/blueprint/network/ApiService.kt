package com.forceson.www.blueprint.network

import com.forceson.www.blueprint.data.Issue
import com.forceson.www.blueprint.data.Repo
import com.forceson.www.blueprint.data.ResponseListModel
import com.forceson.www.blueprint.data.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    fun getUsers(@Query("q") query: String, @Query("sort") sort: String?): Single<ResponseListModel<User>>

    @GET("search/repositories")
    fun getRepos(@Query("q") query: String, @Query("sort") sort: String?): Single<ResponseListModel<Repo>>

    @GET("search/issues")
    fun getIssues(@Query("q") query: String, @Query("sort") sort: String?): Single<ResponseListModel<Issue>>
}