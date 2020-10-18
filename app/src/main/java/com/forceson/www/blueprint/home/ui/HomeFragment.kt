package com.forceson.www.blueprint.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import com.forceson.www.blueprint.R
import com.forceson.www.blueprint.data.Issue
import com.forceson.www.blueprint.data.Repo
import com.forceson.www.blueprint.data.User
import com.forceson.www.blueprint.home.HomeContract
import com.forceson.www.blueprint.home.data.HomeIssueWidget
import com.forceson.www.blueprint.home.data.HomeRepoWidget
import com.forceson.www.blueprint.home.data.HomeUserWidget
import com.forceson.www.blueprint.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), HomeContract.View {
    private lateinit var presenter: HomePresenter
    private lateinit var adapter: HomeItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HomeItemAdapter().apply {
            val user = User(0, "Jake", "")
            val repo = Repo(
                0,
                "BluePrint",
                "forceson/BluePrint",
                user,
                "This!",
                false,
                20,
                40,
                2,
                "Kotlin"
            )
            val issue = Issue(
                0,
                "BluePrint Issue",
                user,
                "open",
                listOf(),
                listOf(),
                300,
                "This!"
            )
            setData(
                listOf(
                    HomeUserWidget(arrayListOf(user, user, user, user, user)),
                    HomeRepoWidget(arrayListOf(repo, repo, repo, repo, repo)),
                    HomeIssueWidget(arrayListOf(issue, issue)),
                    HomeRepoWidget(arrayListOf(repo, repo, repo, repo, repo)),
                    HomeUserWidget(arrayListOf(user, user, user, user, user)),
                    HomeIssueWidget(arrayListOf(issue, issue, issue, issue)),
                    HomeUserWidget(arrayListOf(user, user, user, user, user)),
                )
            )
        }
        presenter = HomePresenter()
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayout.VISIBLE))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment HomeFragment.
         */
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}