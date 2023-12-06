package org.sirekanyan.github.utils

import androidx.recyclerview.widget.DiffUtil

class SimpleItemCallback<T : Any>(private val getId: (T) -> Long) : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        getId(oldItem) == getId(newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        areItemsTheSame(oldItem, newItem)

}
