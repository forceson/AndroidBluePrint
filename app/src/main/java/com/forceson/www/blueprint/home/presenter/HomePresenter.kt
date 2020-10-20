package com.forceson.www.blueprint.home.presenter

import com.forceson.www.blueprint.base.BasePresenter
import com.forceson.www.blueprint.data.Issue
import com.forceson.www.blueprint.data.Repo
import com.forceson.www.blueprint.data.ResponseListModel
import com.forceson.www.blueprint.data.User
import com.forceson.www.blueprint.home.HomeContract
import com.forceson.www.blueprint.home.data.HomeIssueWidget
import com.forceson.www.blueprint.home.data.HomeRepoWidget
import com.forceson.www.blueprint.home.data.HomeUserWidget
import com.forceson.www.blueprint.network.NetworkManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

class HomePresenter(
    private val view: HomeContract.View
) : BasePresenter(), HomeContract.Presenter {


    override fun onCreate() {
        val userQuery =
            URLDecoder.decode("followers:>5000+language:Java", StandardCharsets.UTF_8.displayName())
        val userSort = "stars"
        val repoQuery = URLDecoder.decode("language:Java", StandardCharsets.UTF_8.displayName())
        val repoSort = "stars"
        val issueQuery =
            URLDecoder.decode("language:Java+state:open", StandardCharsets.UTF_8.displayName())
        val issueSort = "comments"
        Single.zip(NetworkManager.getApiService().getUsers(userQuery, userSort),
            NetworkManager.getApiService().getRepos(repoQuery, repoSort),
            NetworkManager.getApiService().getIssues(issueQuery, issueSort),
            { t1: ResponseListModel<User>, t2: ResponseListModel<Repo>, t3: ResponseListModel<Issue> ->
                Triple(t1, t2, t3)
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val users = HomeUserWidget(it.first.items)
                val repos = HomeRepoWidget(it.second.items)
                val issues = HomeIssueWidget(it.third.items)
                view.updateData(listOf(users, repos, issues))
            }, {

            }).addTo(compositeDisposable)
    }

    override fun onResume() {

    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

}