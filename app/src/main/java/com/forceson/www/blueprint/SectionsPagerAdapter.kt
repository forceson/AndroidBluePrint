package com.forceson.www.blueprint

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val titles = arrayListOf<String>()
    private val fragments = arrayListOf<Fragment>()

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]

    fun getPageTitle(position: Int) = titles[position]

    fun addFragment(title: String, fragment: Fragment) {
        titles.add(title)
        fragments.add(fragment)
    }
}