package com.fi.mconceptlayout.screen.homeFragment.mainTask

import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fi.mconceptlayout.R
import com.fi.mconceptlayout.base.BaseActivity
import com.fi.mconceptlayout.utils.MarginItemDecoration
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main_task.*
import kotlinx.android.synthetic.main.bottom_sheet_add_task.*
import kotlinx.android.synthetic.main.content_main_task_header.*
import kotlinx.android.synthetic.main.content_main_task_scrolling.*

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

24/03/2020, 05:12 PM
 ****************************************
 */

class MainTaskActivity : BaseActivity() {
    private lateinit var sheetBehavior: BottomSheetBehavior<View>

    override fun getLayoutResource(): Int = R.layout.activity_main_task

    override fun getToolbarResource(): Int = R.id.toolbar_mainTask

    override fun getToolbarTitle(): String = "Erlangga Cell"

    override fun setToolbarActionButton(): Boolean = true

    override fun mainCode() {
        initHeaderUI()

        initBottomSheetUI()
        initReportUI()

        fab_add.setOnClickListener { fabAdd() }
    }

    private fun initBottomSheetUI(){
        sheetBehavior = BottomSheetBehavior.from<View>(bs_)

        val listReport = listOf(
            Report(
                icon = R.drawable.ic_selling,
                name = "Selling",
                description = "Some Description of Event"
            ),
            Report(
                icon = R.drawable.ic_branding,
                name = "Branding",
                description = "Some Description of Event"
            ),
            Report(
                icon = R.drawable.ic_event,
                name = "Event",
                description = "Some Description of Event"
            ),
            Report(
                icon = R.drawable.ic_socialization,
                name = "Event",
                description = "Some Description of Event"
            )
        )
        val adapter = MainTaskBottomSheetAdapter(this){}
        adapter.data = listReport

        rv_bottomSheet.layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        rv_bottomSheet.adapter = adapter
    }

    private fun fabAdd() {
        if (sheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        } else if (sheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
            sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    private fun initHeaderUI(){
        tv_headerTitle.text = "Outlet"
        val listString = listOf(
            "Jl. A.P. Pettarani, No. 20",
            "Owner, Bpk. Syamsuddin",
            "Phone, +6285 880 223 445",
            "Region Sulawesi • Branch Makassar"
        )

        val adapter =
            MainTaskHeaderAdapter()
        adapter.data = listString
        rv_header.adapter = adapter

        tv_headerDate.text = "Reported At 20 February 2020, 13.00"
    }

    private fun initReportUI(){
        val listReport = listOf(
            Report(
                icon = R.drawable.ic_selling,
                name = "Selling",
                description = "Some Description of Event"
            ),
            Report(
                icon = R.drawable.ic_branding,
                name = "Branding",
                description = "Some Description of Event"
            ),
            Report(
                icon = R.drawable.ic_event,
                name = "Event",
                description = "Some Description of Event"
            ),
            Report(
                icon = R.drawable.ic_socialization,
                name = "Event",
                description = "Some Description of Event"
            )
        )

        val adapter = MainTaskReportAdapter(this){}
        adapter.data = listReport
        rv_report.adapter = adapter
    }

    data class Report(val icon: Int, val name: String, val description: String)

}