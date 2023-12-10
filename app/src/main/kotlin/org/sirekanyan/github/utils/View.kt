package org.sirekanyan.github.utils

import android.view.View

fun View.show(value: Boolean) {
    if (value) show() else hide()
}

fun View.show() {
    alpha = 0f
    visibility = View.VISIBLE
    animate().alpha(1f).setDuration(150)
}

fun View.hide() {
    animate().alpha(0f).setDuration(150).withEndAction {
        visibility = View.GONE
    }
}

fun View.slideIn() {
    alpha = 0f
    translationX = 50f
    visibility = View.VISIBLE
    animate().alpha(1f).translationX(0f).setDuration(150)
}

fun View.slideOut() {
    animate().alpha(0f).translationX(50f).setDuration(150).withEndAction {
        visibility = View.GONE
    }
}
