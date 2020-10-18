package com.forceson.www.blueprint.home.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.forceson.www.blueprint.data.Issue

class HomeIssueWidgetItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = arrayListOf<Issue>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return IssueWidgetViewHolder(HomeIssueWidgetItemView(parent.context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as IssueWidgetViewHolder).v.setData(items[position])
    }

    override fun getItemCount() = items.size

    fun setData(items: List<Issue>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class IssueWidgetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val v = itemView as HomeIssueWidgetItemView
    }
}