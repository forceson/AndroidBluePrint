package com.forceson.www.blueprint.home.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.forceson.www.blueprint.home.data.HomeIssueWidget
import com.forceson.www.blueprint.home.data.HomeRepoWidget
import com.forceson.www.blueprint.home.data.HomeUserWidget

class HomeItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val USER_WIDGET = 100
        const val REPOS_WIDGET = 200
        const val ISSUES_WIDGET = 300
        const val DUMMY = 0
    }

    private val items = arrayListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            USER_WIDGET -> UserWidgetViewHolder(HomeUserWidgetListView(parent.context))
            REPOS_WIDGET -> ReposWidgetViewHolder(HomeRepoWidgetListView(parent.context))
            ISSUES_WIDGET -> IssueWidgetViewHolder(HomeIssueWidgetListView(parent.context))
            else -> DummyViewHolder(View(parent.context))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserWidgetViewHolder -> holder.v.setData(items[position] as HomeUserWidget)
            is ReposWidgetViewHolder -> holder.v.setData(items[position] as HomeRepoWidget)
            is IssueWidgetViewHolder -> holder.v.setData(items[position] as HomeIssueWidget)
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HomeUserWidget -> USER_WIDGET
            is HomeRepoWidget -> REPOS_WIDGET
            is HomeIssueWidget -> ISSUES_WIDGET
            else -> DUMMY
        }
    }

    fun setData(items: List<Any>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class UserWidgetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val v = itemView as HomeUserWidgetListView
    }

    class ReposWidgetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val v = itemView as HomeRepoWidgetListView
    }

    class IssueWidgetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val v = itemView as HomeIssueWidgetListView
    }

    class DummyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}