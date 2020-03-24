package com.fi.mconceptlayout.screen.homeFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fi.mconceptlayout.R
import com.fi.mconceptlayout.model.Content2Column

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

05/03/2020, 06:00 PM
 ****************************************
 */

class HomeFragmentHeaderAdapter : RecyclerView.Adapter<HomeFragmentHeaderAdapter.ViewHolder>() {
    var data = listOf<Content2Column>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.content_2_column, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val label: TextView = itemView.findViewById(R.id.tv_lable)
        private val value: TextView = itemView.findViewById(R.id.tv_value)

        fun bindItem(items: Content2Column?) {
            label.text = items?.label
            value.text = items?.value
        }
    }
}