package com.forceson.www.blueprint.home.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.forceson.www.blueprint.data.Repo

class HomeRepoWidgetItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = arrayListOf<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RepoWidgetViewHolder(HomeRepoWidgetItemView(parent.context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RepoWidgetViewHolder).v.setData(items[position])
    }

    override fun getItemCount() = items.size

    fun setData(items: List<Repo>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class RepoWidgetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val v = itemView as HomeRepoWidgetItemView
    }
}