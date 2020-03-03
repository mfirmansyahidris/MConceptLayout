package com.fi.mconceptlayout.screen

import android.graphics.Color
import android.util.Log
import com.fi.mconceptlayout.R
import com.fi.mconceptlayout.base.BaseFragment
import com.fi.mconceptlayout.utils.Utils
import kotlinx.android.synthetic.main.toolbar_home_header.*

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

02/03/2020, 02:33 PM
 ****************************************
 */

class HomeFragment : BaseFragment(){

    override fun getLayoutResource(): Int = R.layout.fragment_home

    override fun getToolbarColor(): Int? = Color.TRANSPARENT

    override fun mainCode() {

    }
}