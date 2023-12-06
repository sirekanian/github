package org.sirekanyan.github.utils

import android.content.Context
import android.content.res.Resources
import android.view.View
import org.sirekanyan.github.arch.BaseView

val BaseView<*>.rootView: View
    get() = binding.root

val BaseView<*>.context: Context
    get() = rootView.context

val BaseView<*>.resources: Resources
    get() = rootView.resources
