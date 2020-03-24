package com.fi.mconceptlayout.utils

import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.core.view.marginStart
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

24/03/2020, 11:05 AM
 ****************************************
 */

class MarginItemDecoration(private val dimens: Int, private val numColumn: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            val dimensHalf = dimens / 2

            top = if(parent.getChildAdapterPosition(view) < numColumn){
                dimens
            }else{
                dimensHalf
            }

            right = if((parent.getChildAdapterPosition(view) + 1) % numColumn == 0){
                dimens
            }else{
                dimensHalf
            }

            left = if((parent.getChildAdapterPosition(view) + 1) % numColumn == 1){
                dimens
            }else{
                dimensHalf
            }

            bottom = dimensHalf
        }
    }
}