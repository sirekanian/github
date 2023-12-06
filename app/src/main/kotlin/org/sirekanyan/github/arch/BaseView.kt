package org.sirekanyan.github.arch

import androidx.viewbinding.ViewBinding

interface BaseView<T : ViewBinding> {
    val binding: T
}
