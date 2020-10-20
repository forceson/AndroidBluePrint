package com.forceson.www.blueprint.home.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.constraintlayout.widget.ConstraintLayout
import com.forceson.www.blueprint.R
import com.forceson.www.blueprint.home.data.HomeIssueWidget
import kotlinx.android.synthetic.main.home_repo_widget_list_view.view.*

class HomeIssueWidgetListView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val adapter = HomeIssueWidgetItemAdapter()

    init {
        LayoutInflater.from(context).inflate(R.layout.home_issue_widget_list_view, this, true)
        layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        recyclerView.adapter = adapter
    }

    fun setData(homeIssueWidget: HomeIssueWidget) {
        adapter.setData(homeIssueWidget.items)
    }
}