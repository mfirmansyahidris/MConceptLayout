package com.fi.mconceptlayout.screen.homeFragment.mainTask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fi.mconceptlayout.R

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

26/03/2020, 10:43 AM
 ****************************************
 */

class MainTaskHeaderAdapter :
    RecyclerView.Adapter<MainTaskHeaderAdapter.ViewHolder>() {
    var data = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_1_column, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tv: TextView = itemView.findViewById(R.id.tv_)

        fun bindItem(items: String) {
            tv.text = items
        }
    }
}