package org.sirekanyan.github.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

inline fun <reified T : View> ViewGroup.inflate(@LayoutRes layout: Int) =
    LayoutInflater.from(context).inflate(layout, this, false) as T
