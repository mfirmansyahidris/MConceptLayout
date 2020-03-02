package com.fi.mconceptlayout.base

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fi.mconceptlayout.R
import com.fi.mconceptlayout.utils.Utils

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

02/03/2020, 02:29 PM
 ****************************************
 */

abstract class BaseFragment : Fragment() {
    protected lateinit var activity: AppCompatActivity

    protected abstract fun getLayoutResource(): Int

    protected abstract fun getToolbarColor(): Int?

    protected abstract fun mainCode()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)
        return inflater.inflate(getLayoutResource(), container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(Utils().tag, getToolbarColor().toString())

        mainCode()

        if(getToolbarColor() == null){
            @RequiresApi(Build.VERSION_CODES.M)
            activity.window.statusBarColor = activity.getColor(R.color.colorPrimaryDark)
        }else{
            getToolbarColor()?.let {
                activity.window.statusBarColor = it
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as AppCompatActivity
    }

}