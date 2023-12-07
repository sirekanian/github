package org.sirekanyan.github.ui.list

import kotlinx.coroutines.launch
import org.sirekanyan.github.arch.BasePresenter
import org.sirekanyan.github.arch.Presenter
import org.sirekanyan.github.data.GithubApi
import org.sirekanyan.github.data.model.GithubRepo

interface RepoListPresenter : Presenter {

    fun updateList()

    interface Router {
        fun showDetailsScreen(repo: GithubRepo)
    }

}

class RepoListPresenterImpl(
    private val router: RepoListPresenter.Router,
    private val api: GithubApi,
) : BasePresenter<RepoListView>(),
    RepoListPresenter,
    RepoListView.Callbacks {

    override fun updateList() {
        launch {
            try {
                view.showProgress(true)
                val response = api.getGithubRepos(page = 1)
                view.showRepos(response.repos)
            } catch (exception: Exception) {
                // TODO: interface for logger
                // Log.d("Github", "Cannot update list", exception)
                exception.printStackTrace()
                view.showError()
            } finally {
                view.showProgress(false)
            }
        }
    }

    override fun onItemClicked(repo: GithubRepo) {
        router.showDetailsScreen(repo)
    }

}
