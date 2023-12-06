package org.sirekanyan.github.ui.details

import org.sirekanyan.github.arch.BasePresenter
import org.sirekanyan.github.arch.Presenter
import org.sirekanyan.github.data.model.GithubRepo

interface RepoDetailsPresenter : Presenter {

    var state: GithubRepo?
    fun show(repo: GithubRepo?)

    interface Router {
        fun openWebLink(repo: GithubRepo)
    }

}

class RepoDetailsPresenterImpl(
    private val router: RepoDetailsPresenter.Router,
) : BasePresenter<RepoDetailsView>(),
    RepoDetailsPresenter,
    RepoDetailsView.Callbacks {

    private var repo: GithubRepo? = null

    override var state: GithubRepo?
        get() = repo
        set(value) {
            show(value)
        }

    override fun show(repo: GithubRepo?) {
        this.repo = repo
        if (repo == null) {
            view.hide()
        } else {
            view.show(repo)
        }
    }

    override fun onOpenClick() {
        repo?.let {
            router.openWebLink(it)
        }
    }

}
