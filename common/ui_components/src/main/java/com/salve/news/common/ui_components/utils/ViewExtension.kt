package com.salve.news.common.ui_components.utils

import android.view.View

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.remove() {
    this.visibility = View.GONE
}

fun View.enableClick(){
    this.isClickable = true
}

fun View.disableClick(){
    this.isClickable = false
}