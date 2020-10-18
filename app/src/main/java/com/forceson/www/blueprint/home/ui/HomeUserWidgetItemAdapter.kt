package com.forceson.www.blueprint.home.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.forceson.www.blueprint.data.User

class HomeUserWidgetItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = arrayListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserWidgetViewHolder(HomeUserWidgetItemView(parent.context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserWidgetViewHolder).v.setData(items[position])
    }

    override fun getItemCount() = items.size

    fun setData(items: List<User>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class UserWidgetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val v = itemView as HomeUserWidgetItemView
    }
}