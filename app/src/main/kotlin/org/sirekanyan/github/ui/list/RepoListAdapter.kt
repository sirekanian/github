package org.sirekanyan.github.ui.list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sirekanyan.github.R
import org.sirekanyan.github.data.model.GithubRepo
import org.sirekanyan.github.utils.SimpleItemCallback
import org.sirekanyan.github.utils.inflate

class RepoListAdapter(
    private val onItemClick: (GithubRepo) -> Unit,
) : ListAdapter<GithubRepo, RepoItemViewHolder>(SimpleItemCallback { it.id }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoItemViewHolder =
        RepoItemViewHolder(parent.inflate(R.layout.gh_list_item_view), onItemClick)

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
