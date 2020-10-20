package com.forceson.www.blueprint.home.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.forceson.www.blueprint.R
import com.forceson.www.blueprint.home.data.HomeUserWidget
import kotlinx.android.synthetic.main.home_repo_widget_list_view.view.*

class HomeUserWidgetListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val adapter = HomeUserWidgetItemAdapter()

    init {
        LayoutInflater.from(context).inflate(R.layout.home_user_widget_list_view, this, true)
        layoutParams =
            LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        recyclerView.adapter = adapter
    }

    fun setData(homeUserWidget: HomeUserWidget) {
        adapter.setData(homeUserWidget.items)
    }
}