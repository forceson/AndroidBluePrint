package com.forceson.www.blueprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.forceson.www.blueprint.dashboard.ui.DashboardFragment
import com.forceson.www.blueprint.favorite.ui.FavoriteFragment
import com.forceson.www.blueprint.home.ui.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var pagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        initFragmentsWithViewPager()
    }

    private fun initFragmentsWithViewPager() {
        pagerAdapter = SectionsPagerAdapter(this)
        with(viewPager) {
            offscreenPageLimit = 3
            adapter = pagerAdapter?.apply {
                addFragment(getString(R.string.title_home), HomeFragment.newInstance())
                addFragment(getString(R.string.title_dashboard), DashboardFragment.newInstance())
                addFragment(getString(R.string.title_favorite), FavoriteFragment.newInstance())
            }
        }
        bottomNavigationView.setOnNavigationItemSelectedListener {
            navigateToFragment(it)
        }
    }

    private fun navigateToFragment(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                viewPager.currentItem = 0
                true
            }
            R.id.dashboard -> {
                viewPager.currentItem = 1
                true
            }
            R.id.favorite -> {
                viewPager.currentItem = 2
                true
            }
            else -> false
        }
    }
}