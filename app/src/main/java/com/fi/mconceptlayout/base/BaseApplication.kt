package com.fi.mconceptlayout.base

import android.app.Application
import android.util.Log
import com.fi.mconceptlayout.utils.Utils

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

02/03/2020, 02:29 PM
 ****************************************
 */

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(Utils().tag, "application starting")
    }
}