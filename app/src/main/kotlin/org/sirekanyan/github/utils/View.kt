package org.sirekanyan.github.utils

import android.view.View
import android.widget.TextView

fun TextView.showText(value: String?) {
    showNow(value != null)
    text = value
}

fun View.showNow(value: Boolean) {
    if (value) showNow() else hideNow()
}

fun View.showNow() {
    visibility = View.VISIBLE
}

fun View.hideNow() {
    visibility = View.GONE
}

fun View.show(value: Boolean) {
    if (value) show() else hide()
}

fun View.show() {
    animate().alpha(1f).setDuration(200)
        .withStartAction { visibility = View.VISIBLE }
}

fun View.hide() {
    animate().alpha(0f).setDuration(200)
        .withEndAction { visibility = View.GONE }
}
