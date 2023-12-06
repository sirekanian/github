package org.sirekanyan.github.ui.details

import org.sirekanyan.github.arch.BasePresenter
import org.sirekanyan.github.arch.Presenter

interface RepoDetailsPresenter : Presenter {

    interface Router {
    }

}

class RepoDetailsPresenterImpl(
    private val router: RepoDetailsPresenter.Router,
) : BasePresenter<RepoDetailsView>(),
    RepoDetailsPresenter,
    RepoDetailsView.Callbacks {
}
