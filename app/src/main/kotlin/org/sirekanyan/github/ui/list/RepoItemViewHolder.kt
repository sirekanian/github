package org.sirekanyan.github.ui.list

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.sirekanyan.github.R
import org.sirekanyan.github.data.model.GithubRepo

class RepoItemViewHolder(
    view: ViewGroup,
    onItemClick: (GithubRepo) -> Unit,
) : RecyclerView.ViewHolder(view) {

    private var repo: GithubRepo? = null
    private val titleView = view.findViewById<TextView>(R.id.itemTitleView)
    private val descriptionView = view.findViewById<TextView>(R.id.itemDescriptionView)
    private val starsView = view.findViewById<TextView>(R.id.itemStarsView)

    init {
        view.setOnClickListener {
            repo?.let(onItemClick)
        }
    }

    fun bind(repo: GithubRepo) {
        this.repo = repo
        titleView.text = repo.name
        descriptionView.text = repo.description
        starsView.text = repo.formattedStars()
    }

}
