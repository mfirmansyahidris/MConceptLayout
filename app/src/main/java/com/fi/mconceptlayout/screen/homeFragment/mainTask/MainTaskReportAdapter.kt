package com.fi.mconceptlayout.screen.homeFragment.mainTask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.fi.mconceptlayout.R

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

26/03/2020, 02:06 PM
 ****************************************
 */

class MainTaskReportAdapter(
    private val context: Context,
    private val listener: (MainTaskActivity.Report) -> Unit
) :
    RecyclerView.Adapter<MainTaskReportAdapter.ViewHolder>() {
    var data = listOf<MainTaskActivity.Report>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_main_task_report, parent, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position], listener)
    }

    class ViewHolder(itemView: View, private val context: Context) :
        RecyclerView.ViewHolder(itemView) {
        private val ivIcon: ImageView = itemView.findViewById(R.id.iv_icon)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        private val llc: LinearLayoutCompat = itemView.findViewById(R.id.llc_)

        fun bindItem(items: MainTaskActivity.Report, listener: (MainTaskActivity.Report) -> Unit) {
            ivIcon.setImageResource(items.icon)
            tvTitle.text = items.name

            llc.setOnClickListener { listener(items) }
        }
    }
}