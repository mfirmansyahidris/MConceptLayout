package com.fi.mconceptlayout.screen.homeFragment

import android.graphics.Color
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fi.mconceptlayout.R
import com.fi.mconceptlayout.base.BaseFragment
import com.fi.mconceptlayout.model.Content2Column
import com.fi.mconceptlayout.model.MainTask
import com.fi.mconceptlayout.utils.MarginItemDecoration
import kotlinx.android.synthetic.main.content_home_header.*
import kotlinx.android.synthetic.main.content_scrolling_home.*

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

02/03/2020, 02:33 PM
 ****************************************
 */

class HomeFragment : BaseFragment() {
    private lateinit var homeFragmentMainTaskAdapter: HomeFragmentMainTaskAdapter

    override fun getLayoutResource(): Int = R.layout.fragment_home

    override fun getToolbarColor(): Int? = Color.TRANSPARENT

    override fun mainCode() {
        initHeaderLayout()

        initMainTaskLayout()

    }

    private fun initHeaderLayout(){
        tv_bannerTitle.text = getString(R.string.title_banner)

        val content2Columns = listOf(
            Content2Column("Total PJP", "23 Outlets"),
            Content2Column("Remaining PJP", "23 Outlets")
        )

        val adapter = HomeFragmentHeaderAdapter()
        adapter.data = content2Columns

        rv_banner.adapter = adapter
    }

    private fun initMainTaskLayout(){
        val listData = listOf(
            MainTask(
                label = "Outlet",
                color = "",
                title = "Erlangga Cell",
                subtitle = "Jl. Mannuruki 1",
                state = "Not Reported",
                distance = "0.2 Km"
            ),
            MainTask(
                label = "Outlet",
                color = "",
                title = "Erlangga Cell",
                subtitle = "Jl. Mannuruki 1",
                state = "Pending",
                distance = "0.2 Km"
            ),
            MainTask(
                label = "Masjid",
                color = "",
                title = "Erlangga Cell",
                subtitle = "Jl. Mannuruki 1",
                state = "Reported",
                distance = "0.2 Km"
            ),
            MainTask(
                label = "Outlet",
                color = "",
                title = "Erlangga Cell",
                subtitle = "Jl. Mannuruki 1",
                state = "Not Reported",
                distance = "0.2 Km"
            ),
            MainTask(
                label = "Masjid",
                color = "",
                title = "Erlangga Cell",
                subtitle = "Jl. Mannuruki 1",
                state = "Pending",
                distance = "0.2 Km"
            ),
            MainTask(
                label = "Masjid",
                color = "",
                title = "Erlangga Cell",
                subtitle = "Jl. Mannuruki 1",
                state = "Not Reported",
                distance = "0.2 Km"
            ),
            MainTask(
                label = "Outlet",
                color = "",
                title = "Erlangga Cell",
                subtitle = "Jl. Mannuruki 1",
                state = "Not Reported",
                distance = "0.2 Km"
            ),
            MainTask(
                label = "Outlet",
                color = "",
                title = "Erlangga Cell",
                subtitle = "Jl. Mannuruki 1",
                state = "Reported",
                distance = "0.2 Km"
            ),
            MainTask(
                label = "Masjid",
                color = "",
                title = "Erlangga Cell",
                subtitle = "Jl. Mannuruki 1",
                state = "Reported",
                distance = "0.2 Km"
            )
        )

        homeFragmentMainTaskAdapter = HomeFragmentMainTaskAdapter(activity){}
        homeFragmentMainTaskAdapter.data = listData

        rv_mainTask.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rv_mainTask.addItemDecoration(MarginItemDecoration(resources.getDimension(R.dimen.activity_margin_normal).toInt(), 2))

        rv_mainTask.adapter = homeFragmentMainTaskAdapter

    }
}