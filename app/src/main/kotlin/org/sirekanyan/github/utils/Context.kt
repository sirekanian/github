package org.sirekanyan.github.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(@StringRes messageId: Int) {
    Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show()
}
