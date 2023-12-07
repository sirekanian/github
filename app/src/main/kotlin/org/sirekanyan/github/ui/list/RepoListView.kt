package org.sirekanyan.github.ui.list

import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy
import org.sirekanyan.github.R
import org.sirekanyan.github.arch.BaseView
import org.sirekanyan.github.data.model.GithubRepo
import org.sirekanyan.github.databinding.GhListViewBinding
import org.sirekanyan.github.utils.applyInsets
import org.sirekanyan.github.utils.context
import org.sirekanyan.github.utils.resources
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

    private val listAdapter = RepoListAdapter(callbacks::onItemClicked).also {
        it.stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }
    private val progressView = binding.progressView
    private val recyclerView = binding.recyclerView

    init {
        val toolbarSize = resources.getDimensionPixelSize(R.dimen.gh_toolbar_height)
        val listPadding = resources.getDimensionPixelSize(R.dimen.gh_list_item_spacing)
        val listTopPadding = toolbarSize + listPadding
        binding.toolbar.root.applyInsets(WindowInsetsCompat.Type.statusBars())
        progressView.applyInsets(WindowInsetsCompat.Type.statusBars(), toolbarSize)
        recyclerView.applyInsets(WindowInsetsCompat.Type.systemBars(), listTopPadding, listPadding)
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
