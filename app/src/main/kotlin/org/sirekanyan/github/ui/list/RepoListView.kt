package org.sirekanyan.github.ui.list

import org.sirekanyan.github.R
import org.sirekanyan.github.arch.BaseView
import org.sirekanyan.github.data.model.GithubRepo
import org.sirekanyan.github.databinding.GhListViewBinding
import org.sirekanyan.github.utils.context
import org.sirekanyan.github.utils.show
import org.sirekanyan.github.utils.showToast

interface RepoListView : BaseView<GhListViewBinding> {

    fun showRepos(repos: List<GithubRepo>)
    fun showProgress(isVisible: Boolean)
    fun showError()

    interface Callbacks {
        fun onItemClicked(repo: GithubRepo)
    }

}

class RepoListViewImpl(
    override val binding: GhListViewBinding,
    callbacks: RepoListView.Callbacks,
) : RepoListView {

    private val listAdapter = RepoListAdapter(callbacks::onItemClicked)
    private val progressView = binding.progressView
    private val recyclerView = binding.recyclerView

    init {
        recyclerView.adapter = listAdapter
    }

    override fun showRepos(repos: List<GithubRepo>) {
        listAdapter.submitList(repos)
    }

    override fun showProgress(isVisible: Boolean) {
        progressView.show(isVisible)
    }

    override fun showError() {
        context.showToast(R.string.gh_error_text)
    }

}
