package com.fi.mconceptlayout.screen.homeFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.fi.mconceptlayout.R

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

17/03/2020, 08:07 AM
 ****************************************
 */

class HomeFragmentMainTaskAdapter(
    private val context: Context,
    private val listener: (HomeFragment.MainTask) -> Unit
) :
    RecyclerView.Adapter<HomeFragmentMainTaskAdapter.ViewHolder>() {
    var data = listOf<HomeFragment.MainTask>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_home_main_task, parent, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position], listener)
    }

    class ViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {
        private val tvItemTitle: TextView = itemView.findViewById(R.id.tv_itemTitle)
        private val clBanner: ConstraintLayout = itemView.findViewById(R.id.cl_banner)
        private val ivIcon: ImageView = itemView.findViewById(R.id.iv_icon)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        private val tvSubtitle: TextView = itemView.findViewById(R.id.tv_subtitle)
        private val tvState: TextView = itemView.findViewById(R.id.tv_state)
        private val tvDistance: TextView = itemView.findViewById(R.id.tv_distance)
        private val llcMainTask: LinearLayoutCompat = itemView.findViewById(R.id.llc_mainTask)


        fun bindItem(items: HomeFragment.MainTask, listener: (HomeFragment.MainTask) -> Unit) {
            tvItemTitle.text = items.label
            tvTitle.text = items.title
            tvSubtitle.text = items.subtitle
            tvState.text = items.state
            tvDistance.text = items.distance

            when (items.state) {
                "Not Reported" -> {
                    tvState.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorTextStateNormal
                        )
                    )
                }
                "Pending" -> {
                    tvState.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorTextStatePending
                        )
                    )
                }
                "Reported" -> {
                    tvState.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorTextStateReported
                        )
                    )
                }
            }

            when (items.label) {
                "Outlet" -> {
                    clBanner.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorTaskBanner_outlet
                        )
                    )
                    ivIcon.setImageResource(R.drawable.ic_store)
                }
                "Masjid" -> {
                    clBanner.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorTaskBanner_mosque
                        )
                    )
                    ivIcon.setImageResource(R.drawable.ic_mosque)
                }
            }

            llcMainTask.setOnClickListener { listener(items) }
        }
    }
}