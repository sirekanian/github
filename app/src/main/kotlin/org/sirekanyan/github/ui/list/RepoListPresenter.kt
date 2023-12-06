package org.sirekanyan.github.ui.list

import org.sirekanyan.github.arch.BasePresenter
import org.sirekanyan.github.arch.Presenter
import org.sirekanyan.github.data.GithubApi

interface RepoListPresenter : Presenter {

    interface Router {
    }

}

class RepoListPresenterImpl(
    private val router: RepoListPresenter.Router,
    private val api: GithubApi,
) : BasePresenter<RepoListView>(),
    RepoListPresenter,
    RepoListView.Callbacks {
}
