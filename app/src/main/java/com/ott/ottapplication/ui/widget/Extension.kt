package com.ott.ottapplication.ui.widget

import android.view.View

object Extension {

    fun View.setCustomVisibility(show: Boolean) {
        visibility = if (show) View.GONE
        else View.VISIBLE
    }

}