package com.fi.mconceptlayout.model

import java.io.Serializable

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

17/03/2020, 08:09 AM
 ****************************************
 */

data class MainTask(
    var label: String? = "",
    var color: String? = "",
    var title: String? = "",
    var subtitle: String? = "",
    var state: String? = "",
    var distance: String? = ""
)