package org.sirekanyan.github.utils

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat.Type.InsetsType

fun View.applyInsets(@InsetsType typeMask: Int, top: Int = 0, bottom: Int = 0) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { view, windowInsets ->
        val insets = windowInsets.getInsets(typeMask)
        view.setPadding(insets.left, insets.top + top, insets.right, insets.bottom + bottom)
        windowInsets
    }
}
