package com.forceson.www.blueprint.home.ui

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.forceson.www.blueprint.R
import com.forceson.www.blueprint.data.Issue
import kotlinx.android.synthetic.main.home_issue_widget_item_view.view.*

class HomeIssueWidgetItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.home_issue_widget_item_view, this, true)
        layoutParams =
            LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun setData(issue: Issue) {
        stateImg.imageTintList = if (issue.state == "open") {
            ContextCompat.getColorStateList(context, R.color.colorOpen)
        } else ContextCompat.getColorStateList(context, R.color.colorClose)
        titleTxt.text = issue.title
        issue.user.avatarUrl?.let { userAvatarImg.setImageURI(Uri.parse(it)) }
        usernameTxt.text = issue.user.name
        commentCntTxt.text = issue.comments.toString()
    }
}