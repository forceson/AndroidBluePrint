package com.forceson.www.blueprint.home.ui

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.forceson.www.blueprint.R
import com.forceson.www.blueprint.data.Repo
import kotlinx.android.synthetic.main.home_repo_widget_item_view.view.*

class HomeRepoWidgetItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.home_repo_widget_item_view, this, true)
        layoutParams =
            LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun setData(repo: Repo) {
        titleTxt.text = repo.name
        userAvatarImg.setImageURI(Uri.parse(repo.owner.avatarUrl))
        usernameTxt.text = repo.owner.name
        stargazersCntTxt.text = "Stargazers\n${repo.stargazersCount}"
        watchersCntTxt.text = "Watchers\n${repo.watchersCount}"
        forksCntTxt.text = "Forks\n${repo.forksCount}"
        language.text = repo.language
    }
}